#ifndef FILEHANDLER_H_
#define FILEHANDLER_H_
#define DELIMITERCHAR "|"
#define ENDCHAR "#"

typedef struct book_t {
    int id;
    char title[100];
    char author[100];
    long int byteoffset;
} book_t;

void writeBookDataInFile ( book_t* book , char* file);
void readBookDataInFile ( book_t* list, char* file, int m);
#endif //FILEHANDLER_H_