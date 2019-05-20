#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int value = 5;

int main()
{
    pid_t pid;
    pid = fork();
    if (pid ==0)
    {
        value += 15;
    }
    else if (pid > 0)
    { 
        wait(NULL);
        printf("PARENT: value = %d",value); 
        exit(0);
    }
}

/* Print result is "PARENT: value = 5". 
Because the value is not shared between parent and sub processes.*/
