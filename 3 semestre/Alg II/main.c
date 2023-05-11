#include<stdio.h>
#include<stdlib.h>
#include "FileHandler.h"

int n; // número de entradas
int m; // número de registros que devem sair
char a[9] = "save";

int main(){

    //Numero de livros adicionados
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        book_t* book = (book_t*) malloc(sizeof(book_t));
        scanf("%d", &book->id);
        scanf(" %[^(\r|\n)]", book->title);
        scanf(" %[^(\r|\n)]", book->author);
        
        writeBookDataInFile ( book, a);
        free(book);
    }

    //Os livros a serem lidos e printados
    scanf("%d", &m);
    int skip = n - m;
    book_t list[n];

    readBookDataInFile( list, a, n);

    for(int i = skip; i < n; i++){
        printf("Id: %d\n", list[i].id);
        printf("Titulo: %s\n", list[i].title);
        printf("Autor: %s\n", list[i].author);
        printf("Byteoffset: %ld\n", list[i].byteoffset);
        printf("\n");
    }

    return 0;
}
