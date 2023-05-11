#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "FileHandler.h"

/*void storeBookDataInFile ( books_t book, int n, FILE* filePointer){
    for(int i = 0; i < n; i++){
        books_t book = books_t malloc(sizeof(books_t));
        scanf("%d", &book.id);
        scanf(" %[^(\r|\n)]", book.title);
        scanf(" %[^(\r|\n)]", book.author);
        
        writeBookDataInFile ( book, filePointer);
        free(books_t);
    }
}*/

/*void writeBookDataInFile ( books_t* book, char* filePointer )
{
    char fieldSizeAuthor ;
    fieldSizeAuthor = sizeof ( book.author );//mede o tamanho do campo autor
    char fieldSizeTitle ;
    fieldSizeTitle = sizeof ( book.title );//mede o tamanho do campo
    
    int authorLenght = strlen(book.author);

    FILE* file = fopen(filePointer, "ab");
    if(file == NULL){
        printf("Nao foi possivel abrir o arquivo");
        return;
    }

    //Escreve o id do livro no arquivo
    fwrite (& book.id , sizeof(int) , 1, filePointer );
    //Escreve o titulo do livro no arquivo
    fwrite (& book.title , fieldSizeTitle , 1, filePointer );
    //Escreve o caractere delimitador no arquivo
    fputc (DELIMITERCHAR, filePointer);
    //Escreve o comprimento do autor no arquivo
    fwrite (& authorLenght, sizeof(int), 1, filePointer);
    //Escreve o autor do livro no arquivo
    fwrite (& book.author , fieldSizeAuthor , 1, filePointer );
    //Escreve "-1" para indicar o fim do registro
    fputc (ENDCHAR, filePointer);

    fclose(file);
}*/

void writeBookDataInFile( book_t* book, char* filePointer )
{
    int authorLength = strlen(book->author);

    FILE* file = fopen(filePointer, "ab");
    if(file == NULL){
        printf("Não foi possível abrir o arquivo\n");
        return;
    }

    // Escreve o id do livro no arquivo
    fwrite (& (book->id) , sizeof(int) , 1, file);
    // Escreve o título do livro no arquivo
    fwrite (& (book->title) , sizeof(char) , strlen(book->title), file);
    // Escreve o caractere delimitador no arquivo
    fwrite ("|", sizeof(char), 1, file);
    // Escreve o autor do livro no arquivo
    fwrite (& (book->author) , sizeof(char) , strlen(book->author), file );
    // Escreve o comprimento do autor no arquivo
    fwrite (& authorLength, sizeof(int), 1, file);
    // Escreve "-1" para indicar o fim do registro
    fwrite ("#", sizeof(char), 1, file);

    fclose(file);
}

void readBookDataInFile ( book_t* list, char* filePointer, int n){
    
    FILE* file = fopen(filePointer, "rb");
    if(file == NULL){
        printf("Nao foi possivel ler o arquivo");
        return;
    }

    fseek(file, 0, SEEK_END);
    long size = ftell(file);
    rewind(file);

    int i = 0;
    while (ftell(file) < size && 1 < n){

        //Le o id
        fread(&(list[i].id), sizeof(int), 1, file);

        //Le o titulo
        int j = 0;
        char skip = fgetc(file);
        while(skip != '|'){
            list[i].title[j] = skip;
            j++;
            skip = fgetc(file);
        }
        
        list[i].title[j] = '\0';

        //Le o autor
        int authorLenght;
        fread(&authorLenght, sizeof(int), 1, file);
        fread(list[i].author, sizeof(char), authorLenght, file);
        skip = fgetc(file);
        i++;
        
    }

    fclose(file);
}

/*void printBookDataOnScreen(books_t book, int n, int m, FILE* filePointer){
    int skip = n - m;
    readBookDataInFile ( book, m, filePointer);

    for(int i = skip; i < n; i++){
        printf("Id: %d\n", list[i].id);
        printf("Titulo: %s\n", list[i].title);
        printf("Autor: %s\n", list[i].author);
        printf("Byteoffset: %d\n", list[i].byteoffset);
        printf("\n");
    }
}*/
