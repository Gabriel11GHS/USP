FileHandler.h:

#ifndef FILEHANDLER_H_INCLUDED
#define FILEHANDLER_H_INCLUDED

typedef struct Registro {
int id;
char *titulo;
char *autor;
long byteOffset;
} Registro;

void escreverRegistro(FILE *fp, Registro registro);
void lerUltimosRegistros(FILE *fp, int m, Registro registros[]);

#endif // FILEHANDLER_H_INCLUDED