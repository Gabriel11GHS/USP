#include<stdio.h>
#include<stdlib.h>
#include "FileHandler.h"

int main(){
int n; // número de entradas
int m; // número de registros que devem ser impressos
int i;
int id;
char titulo[100];
char autor[100];
FILE *fp;
scanf("%d", &n);
Registro registros[n];

for(i=0;i<n;i++){
    scanf("%d", &id);
    scanf("%s", titulo);
    scanf("%s", autor);
    
    registros[i].id = id;
    registros[i].titulo = (char*)malloc(strlen(titulo)*sizeof(char));
    registros[i].autor = (char*)malloc(strlen(autor)*sizeof(char));
    strcpy(registros[i].titulo, titulo);
    strcpy(registros[i].autor, autor);
}

fp = fopen("registros.bin", "wb");

for(i=0;i<n;i++){
    escreverRegistro(fp, registros[i]);
}

scanf("%d", &m);

Registro ultimosRegistros[m];
lerUltimosRegistros(fp, m, ultimosRegistros);

for(i=0;i<m;i++){
    printf("Id: %d\n", ultimosRegistros[i].id);
    printf("Titulo: %s\n", ultimosRegistros[i].titulo);
    printf("Autor: %s\n", ultimosRegistros[i].autor);
    printf("Byte offset: %ld\n", ultimosRegistros[i].byteOffset);
}

fclose(fp);

for(i=0;i<n;i++){
    free(registros[i].titulo);
    free(registros[i].autor);
}

return 0;
}