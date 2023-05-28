#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "livro.h"
#include "livro.c"


int main()
{
    int id;
    char autor[MAX_AUTOR];
    char titulo[MAX_AUTOR];
    char comando[100];
    long int numRegistros = 0;
    EstruturaPrimaria indiceP[MAX_REGISTROS];
    EstruturaSecundaria indiceS[MAX_REGISTROS];

    FILE *arquivoDados = fopen("dados.txt", "r+b");

    if (arquivoDados == NULL)
    {// Abre o arquivo de dados se ainda não existir
        arquivoDados = fopen("dados.txt", "w+b");
    }

    while (1)
    {
        FILE *indicePrimario = fopen("indice_primario.txt", "a+");
        FILE *indiceSecundario = fopen("indice_secundario.txt", "a+");
        fgets(comando, sizeof(comando), stdin);

        if (strncmp(comando, "ADD", 3) == 0)
        {// Se o comando for ADD
            sscanf(comando, "ADD id='%d' titulo='%[^']' autor='%[^']'", &id, titulo, autor);
            Livro livro;
            livro.id = id;
            strcpy(livro.titulo, titulo);
            strcpy(livro.autor, autor);

            // Verifica se o id já existe no índice primário
            rewind(indicePrimario);
            int indiceId;
            long indicePosicao;
            int idDuplicado = 0;
            while (fscanf(indicePrimario, "%d-%ld", &indiceId, &indicePosicao) == 2)
            {
                if (indiceId == id)
                {
                    idDuplicado = 1;
                    break;
                }
            }
            if (idDuplicado)
            {
                printf("----------------------------------------------------------\n");
                printf("Erro ao inserir registro, chave primária duplicada\n");
            }
            else
            {// Se não existir, insere o registro
                inserirLivro(arquivoDados, livro, indiceP, indiceS, numRegistros);
                atualizarIndiceSecundario(indiceSecundario, indiceS[numRegistros].autor, numRegistros);
                atualizarIndicePrimario(indicePrimario, indiceP[numRegistros].id, indiceP[numRegistros].posicao); // printf("%ld\n", numRegistros);
                numRegistros++;
                printf("----------------------------------------------------------\n");
                printf("Registro inserido\n");
            }
        }

        // SEARCH id=''
        else if (strncmp(comando, "SEARCH id", 9) == 0)
        {
            sscanf(comando, "SEARCH id='%d'", &id);
            // buscarPorId(arquivoDados, id);
            buscarPorId(arquivoDados, indicePrimario, id);
        }
        // SEARCH autor=''
        else if (strncmp(comando, "SEARCH autor", 12) == 0)
        {
            sscanf(comando, "SEARCH autor='%[^']'", autor);
            buscarPorAutor(arquivoDados, indiceSecundario, autor);

            // buscarPorAutor(arquivoDados, indiceS, numRegistros, livro.autor);
        }
        // REMOVE id=''
        else if (strncmp(comando, "REMOVE id", 9) == 0)
        {
            sscanf(comando, "REMOVE id='%d'", &id);
            // removerPorId(arquivoDados, indicePrimario, indiceSecundario, id);
            removerPorId(arquivoDados, indicePrimario, indiceSecundario, id);
        }
        // REMOVE autor=''
        else if (strncmp(comando, "REMOVE autor", 12) == 0)
        {
            sscanf(comando, "REMOVE autor='%[^']'", autor);
            removerPorAutor(arquivoDados, indicePrimario, indiceSecundario, autor);
        }
        // EXIT
        else if (strncmp(comando, "EXIT", 4) == 0)
        {
            break;
        }
        fclose(indicePrimario);
        fclose(indiceSecundario);
    }

    fclose(arquivoDados);

    return 0;
}