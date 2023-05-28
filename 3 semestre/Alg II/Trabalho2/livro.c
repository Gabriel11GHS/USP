#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "livro.h"

// Função para inserir o registro no arquivo de dados
void inserirLivro(FILE *arquivoDados, Livro livro, EstruturaPrimaria *indiceP, EstruturaSecundaria *indiceS, long int numRegistros)
{
    fseek(arquivoDados, 0, SEEK_END);
    fwrite(&livro, sizeof(Livro), 1, arquivoDados);

    indiceP[numRegistros].id = livro.id;
    indiceP[numRegistros].posicao = ftell(arquivoDados) - sizeof(Livro);
    strcpy(indiceS[numRegistros].autor, livro.autor);
}

// Função para atualizar o índice primário (id -> posição do registro no arquivo)
void atualizarIndicePrimario(FILE *indicePrimario, int id, long int posicao)
{
    fprintf(indicePrimario, "%d-%ld\n", id, posicao);
}

// Função para atualizar o índice secundário (autor -> posição do registro no arquivo)
void atualizarIndiceSecundario(FILE *indiceSecundario, char autor[MAX_AUTOR], long int posicao)
{
    fprintf(indiceSecundario, "'%s' i%ld\n", autor, posicao);
}

// Função para printar o registro, buscando pelo id
void buscarPorId(FILE *arquivo, FILE *indicePrimario, int id)
{
    Livro livro;
    int indiceId;
    long int indicePosicao;
    int encontrado = 0;

    rewind(arquivo);
    printf("----------------------------------------------------------\n");

    while (fscanf(indicePrimario, "%d-%ld", &indiceId, &indicePosicao) == 2)
    {// Lê todas as linhas do arquivo de índice primário
        if (indiceId == id)
        {// Se o id do índice primário for igual ao id buscado
            while (fread(&livro, sizeof(Livro), 1, arquivo) == 1)
            {// Lê todos os registros do arquivo de dados
                if (indiceId == livro.id && livro.id != -1)
                {// Se o id do índice primário for igual ao id do registro e o registro não estiver removido
                    printf("%d - %s - %s\n", livro.id, livro.titulo, livro.autor);
                    encontrado = 1;
                }
            }
        }
    }
    if (!encontrado)
    {
        printf("Não encontrado\n");
    }
    encontrado = 0;
}

// Função para printar o registro, buscando pelo autor
void buscarPorAutor(FILE *arquivo, FILE *indiceSecundario, char autor[MAX_AUTOR])
{
    Livro livro;
    int encontrado = 0;
    char linha[MAX_AUTOR];
    char indiceAutor[MAX_AUTOR];

    rewind(arquivo);
    printf("----------------------------------------------------------\n");
    while (fgets(linha, MAX_AUTOR, indiceSecundario) != NULL)
    {// Lê todas as linhas do arquivo de índice secundário
        sscanf(linha, "'%[^']'", indiceAutor);
        if (strcmp(indiceAutor, autor) == 0)
        {// Se o autor do índice secundário for igual ao autor buscado
            while (fread(&livro, sizeof(Livro), 1, arquivo) == 1)
            {// Lê todos os registros do arquivo de dados
                if (strcmp(indiceAutor, livro.autor) == 0 && livro.id != -1)
                {// Se o autor do índice secundário for igual ao autor do registro e o registro não estiver removido
                    printf("%d - %s - %s\n", livro.id, livro.titulo, livro.autor);
                    encontrado = 1;
                }
            }
        }
    }
    if (!encontrado)
    {
        printf("Não encontrado\n");
    }
    encontrado = 0;
}

// Função para remover por ID
void removerPorId(FILE *arquivo, FILE *indicePrimario, FILE *indiceSecundario, int id)
{
    Livro livro;
    long posicao;
    int indiceId;
    long indicePosicao;
    int removido = -1;
    int registroRemovido = 0;
    char linha[MAX_AUTOR];
    char indiceAutor[MAX_AUTOR];

    rewind(arquivo);
    while (fread(&livro, sizeof(Livro), 1, arquivo) == 1)
    {// Lê todos os registros do arquivo de dados
        if (livro.id == id)
        {// Se o id do registro for igual ao id buscado
            posicao = ftell(arquivo) - sizeof(Livro);
            fseek(arquivo, posicao, SEEK_SET);
            fwrite(&removido, sizeof(int), 1, arquivo);
            printf("----------------------------------------------------------\n");
            printf("Registro removido\n");
            registroRemovido++;
            livro.id = -1;
        }
        if (livro.id == -1)
        {// Se o registro estiver removido

            rewind(indicePrimario);
            rewind(indiceSecundario);

            // Abre os arquivos temporários
            FILE *tmpIndicePrimario = fopen("tmp_indice_primario.txt", "w");
            FILE *tmpIndiceSecundario = fopen("tmp_indice_secundario.txt", "w");

            while (fscanf(indicePrimario, "%d-%ld", &indiceId, &indicePosicao) == 2 && fgets(linha, MAX_AUTOR, indiceSecundario) != NULL)
            { // Lê todas as linhas do arquivo de índice primário e secundário
                sscanf(linha, "'%[^']' i%ld", indiceAutor, &indicePosicao);
                if (indiceId != id)
                {// Se o id do índice primário for diferente do id buscado
                    fprintf(tmpIndicePrimario, "%d-%ld\n", indiceId, indicePosicao);
                    fprintf(tmpIndiceSecundario, "'%s' i%ld\n", indiceAutor, indicePosicao);
                }
            }
            
            // Fecha o arquivo e renomeia o arquivo temporário para o nome original
            fclose(tmpIndicePrimario);
            remove("indice_primario.txt");
            rename("tmp_indice_primario.txt", "indice_primario.txt");

            //Fecha o arquivo e renomeia o arquivo temporário para o nome original
            fclose(tmpIndiceSecundario);
            remove("indice_secundario.txt");
            rename("tmp_indice_secundario.txt", "indice_secundario.txt");
        }
    }
    if (registroRemovido == 0)
    {
        printf("----------------------------------------------------------\n");
        printf("Erro ao remover\n");
    }
    else
    {
        registroRemovido = 0;
    }
}

// Função para remover por autor
void removerPorAutor(FILE *arquivo, FILE *indicePrimario, FILE *indiceSecundario, char autor[MAX_AUTOR])
{
    Livro livro;
    int indiceId;
    long indicePosicao;
    int registroRemovido = 0;
    char linha[MAX_AUTOR];
    char indiceAutor[MAX_AUTOR];
    

    rewind(arquivo);
    printf("----------------------------------------------------------\n");

    while (fgets(linha, MAX_AUTOR, indiceSecundario) != NULL)
    {//Percorre todas as linhas do arquivo de indice secundario
        sscanf(linha, "'%[^']'", indiceAutor);
        if (strcmp(indiceAutor, autor) == 0)
        {//Se o autor da linha for igual ao autor passado como parametro
            while (fread(&livro, sizeof(Livro), 1, arquivo) == 1)
            {//Percorre todos os registros do arquivo de dados
                if (strcmp(livro.autor, autor) == 0)
                {//Se o autor do registro for igual ao autor passado como parametro
                    id = livro.id;
                    printf("Registro removido\n");
                    registroRemovido++;
                }
                    // Abre o arquivo do indice primario no inicio
                    rewind(indicePrimario);
                    FILE *tmpIndicePrimario = fopen("tmp_indice_primario.txt", "w");
                    // Abre o arquivo do indice secundario no inicio
                    rewind(indiceSecundario);
                    FILE *tmpIndiceSecundario = fopen("tmp_indice_secundario.txt", "w");

                    while (fscanf(indicePrimario, "%d-%ld\n", &indiceId, &indicePosicao) == 2 && fgets(linha, MAX_AUTOR, indiceSecundario) != NULL)
                    { // a função fscanf retorna o número de valores lidos.

                        sscanf(linha, "'%[^']' i%ld", indiceAutor, &indicePosicao);
                        if (strcmp(indiceAutor, autor) != 0)
                        {
                            fprintf(tmpIndicePrimario, "%d-%ld\n", indiceId, indicePosicao);
                            fprintf(tmpIndiceSecundario, "'%s' i%ld\n", indiceAutor, indicePosicao);
                        }
                    }

                    // Fecha o arquivo temporário e renomeia o arquivo temporário para o nome original
                    fclose(tmpIndicePrimario);
                    remove("indice_primario.txt");
                    rename("tmp_indice_primario.txt", "indice_primario.txt");

                    // Fecha o arquivo temporário e renomeia o arquivo temporário para o nome original
                    fclose(tmpIndiceSecundario);
                    remove("indice_secundario.txt");
                    rename("tmp_indice_secundario.txt", "indice_secundario.txt");
                
            }
        }
    }

    if (registroRemovido == 0)
    {
        printf("Erro ao remover\n");
    }
    else
    {
        registroRemovido = 0;
    }
}
