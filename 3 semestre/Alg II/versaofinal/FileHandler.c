#include "FileHandler.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void writeRegisterToFile(Register reg, FILE* file) {
    // Escreve o id do registro no arquivo
    fwrite(&reg.id, sizeof(reg.id), 1, file);

    // Escreve o título do registro no arquivo
    int titleLength = strlen(reg.title);
    fwrite(reg.title, sizeof(char), titleLength, file);

    // Escreve o delimitador do título no arquivo
    char titleDelimiter = '|';
    fwrite(&titleDelimiter, sizeof(char), 1, file);

    // Escreve o tamanho do autor no arquivo
    int authorLength = strlen(reg.author);
    fwrite(&authorLength, sizeof(authorLength), 1, file);

    // Escreve o autor no arquivo
    fwrite(reg.author, sizeof(char), authorLength, file);

    // Escreve o delimitador de registro no arquivo
    char registerDelimiter = -1;
    fwrite(&registerDelimiter, sizeof(char), 1, file);
}

Register readRegisterFromFile(int offset, FILE* file) {
    // Move o ponteiro do arquivo para o offset especificado
    fseek(file, offset, SEEK_SET);

    Register reg;

    // Lê o id do registro do arquivo
    fread(&reg.id, sizeof(reg.id), 1, file);

    // Lê o título do registro do arquivo
    char title[100];
    int titleLength = 0;
    char titleDelimiter;
    do {
        fread(&titleDelimiter, sizeof(char), 1, file);
        if (titleDelimiter != '|') {
            title[titleLength] = titleDelimiter;
            titleLength++;
        }
    } while (titleDelimiter != '|');
    title[titleLength] = '\0';
    strcpy(reg.title, title);

    // Lê o tamanho do autor do registro do arquivo
    int authorLength;
    fread(&authorLength, sizeof(authorLength), 1, file);

    // Lê o autor do registro do arquivo
    char author[100];
    fread(author, sizeof(char), authorLength, file);
    author[authorLength] = '\0';
    strcpy(reg.author, author);

    return reg;
}

void printLastMRegisters(int m, FILE* file) {
    // Obtém o tamanho do arquivo
    fseek(file, 0, SEEK_END);
    long fileSize = ftell(file);

    // Calcula o número de registros presentes no arquivo
    int numRegisters = fileSize / (sizeof(int) + 100 + sizeof(char) + sizeof(int) + 100 + sizeof(char));

    // Caso o número de registros a serem impressos seja maior que o número de registros no arquivo,
    // atualiza a variável m para imprimir todos os registros
    if (m > numRegisters) {
        m = numRegisters;
    }

    // Obtém o offset do último registro que deve ser impresso
    int lastRegisterOffset = fileSize - (m * (sizeof(int) + 100 + sizeof(char) + sizeof(int) + 100 + sizeof(char)));

    // Imprime os últimos m registros presentes no arquivo
    for (int i = lastRegisterOffset; i < fileSize; i += (sizeof(int) + 100 + sizeof(char) + sizeof(int) + 100 + sizeof(char))) {
        Register reg = readRegisterFromFile(i, file);

        printf("Id: %d\n", reg.id);
        printf("Titulo: %s\n", reg.title);
        printf("Autor: