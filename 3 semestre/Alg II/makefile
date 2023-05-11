CC = gcc
CFLAGS = -Wall
objects = main.o FileHandler.o

run: main
	./main
	
all: main

main: FileHandler.o main.c
	$(CC) -o main FileHandler.o main.c
	
FileHandler.o: FileHandler.c FileHandler.h
	$(CC) -c FileHandler.c
	
clean:
	rm main $(objects)