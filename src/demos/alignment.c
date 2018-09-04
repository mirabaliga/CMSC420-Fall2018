#include <stdio.h>
#include <stdlib.h>

typedef unsigned char byte; 

typedef struct myStruct {
	int a;
	double d;
	char c;
	byte b;
} myStruct;

int main(int argc, char** argv){
	printf("On this machine, size of int =%lu bytes.\n", sizeof(int));
	printf("On this machine, size of a double =%lu bytes.\n", sizeof(double));
	printf("On this machine, size of a char =%lu bytes. \n", sizeof(char));
	printf("On this machine, size of a byte =%lu bytes. \n", sizeof(byte));
	printf("On this machine, size of a myStruct =%lu bytes.\n", sizeof(myStruct));
	return EXIT_SUCCESS;	
}
