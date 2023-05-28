CC = gcc
CFLAGS = -Wall
objects = main.o livro.o

run: main
	./main
	
all: main

main: livro.o main.c
	$(CC) -o main livro.o main.c
	
livro.o: livro.c livro.h
	$(CC) -c livro.c
	
clean:
	rm main $(objects)