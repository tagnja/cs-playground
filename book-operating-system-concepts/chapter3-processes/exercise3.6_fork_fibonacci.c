#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int main()
{
    int n, a = 0, b = 1;
    printf("Please input the n for Fibonacci.\n");
    scanf("%d", &n);
    if (n <= 0)
    {
        printf("Please input number is greater than 0.\n");
    }
    else
    {
        int pid = fork();
        if (pid == 0)
        {
            for (int i = 0; i < n; i++)
            {
                printf("%d ", b);
                b += a;
                a = b; 
            }
            printf("\n");
        }
        else if (pid > 0)
        {
            wait(NULL);
            printf("The sub process is finished.\n");
        }
    }
    return 0;
}
