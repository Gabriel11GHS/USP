
#ifndef LIVRO_H_
#define LIVRO_H_
#define MAX_AUTOR 100
#define MAX_REGISTROS 100

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Estrutura de um registro de livro
typedef struct
{
    int id;
    char titulo[100];
    char autor[100];
} Livro;

typedef struct
{
    int id;
    long posicao;
} EstruturaPrimaria;

typedef struct
{
    char autor[100];
    long posicao;
} EstruturaSecundaria;

int id;

void inserirRegistro(FILE *arq, Livro livro, EstruturaPrimaria *estruturaP, EstruturaSecundaria *estruturaS, long int Registros);
void atualizarIndicePrimario(FILE *arq, int id, long posicao);
void atualizarIndiceSecundario(FILE *arq, char Aautor[100], long posicao);
void buscarPorId(FILE *arq, FILE *arq2, int id);
void buscarPorAutor(FILE *arq, FILE *arq3, char Aautor[100]);
void removerPorId(FILE *arq, FILE *arq2, FILE *arq3, int id);
void removerPorAutor(FILE *arq, FILE *arq2, FILE *arq3, char Aautor[100]);
#endif