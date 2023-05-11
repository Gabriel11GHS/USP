#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main(){
    int n, i, id, j;
    char titulo[100];
    char autor[100];
    char delimitadorT = '|';
    char delimitadorR = -1;
    scanf("%d", &n);
    FILE* pFile = fopen("livros.txt", "wb");
if(pFile==NULL)
{
printf("Erro ao abrir");
}
    for(i = 0; i < n; i++){
        scanf("%d", &id);
        getchar();//descarta o /n
        fgets(titulo, 100, stdin);//lê entrada padrão do teclado
        titulo[strcspn(titulo, "\n")] = '\0';//corta possíveis "quebras" de linha e armazena
        //o tamanho da string antes do /n
        fgets(autor, 100, stdin);
        autor[strcspn(autor, "\n")] = '\0';
        //fwrite grava blocos de dados em um arquivo (registros)
        fwrite(&id, sizeof(int), 1, pFile);
        fwrite(titulo, sizeof(char), strlen(titulo), pFile);
        fwrite(&delimitadorT, sizeof(char), 1, pFile);//delimitador do título
        int comprimA = strlen(autor);
        fwrite(&comprimA, sizeof(int), 1, pFile);//comprimento da string autor
        fwrite(autor, sizeof(char), comprimA, pFile);
        fwrite(&delimitadorR, sizeof(char), 1, pFile);//delimitador do registro
    }
    fclose(pFile);
    int m;
    scanf("%d", &m);
    pFile = fopen("livros.txt", "rb");
    for(int j = m; j > 0; j--){
        fread(&id, sizeof(int), 1, pFile);
        fread(titulo, sizeof(char), 100, pFile);
        titulo[strcspn(titulo, &delimitadorT)] = '\0';
        int comprimA;
        fread(&comprimA, sizeof(int), 1, pFile);
        fread(autor, sizeof(char), 100, pFile);
        autor[comprimA] = '\0';
        long byteoffset = ftell(pFile) - (strlen(autor) + sizeof(int) + sizeof(char) + strlen(titulo) + sizeof(int) + sizeof(char));
        printf("Id: %d\n", id);
        printf("Titulo: %s\n", titulo);
        printf("Autor: %s\n", autor);
        printf("Byte offset: %ld\n", byteoffset);
    }
    fclose(pFile);
    return 0;
}