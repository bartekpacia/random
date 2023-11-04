#include <stdio.h>
#include <sys/time.h>
#include <unistd.h>

const int n = 10000;

int main() {
    struct timeval start, end;
    gettimeofday(&start, NULL);

    for (int i = 0; i < n; i++) {
        struct timeval time;
        read(STDIN_FILENO, NULL, 0);
        printf("hello %d\n", i);
    }

    gettimeofday(&end, NULL);

    int diff = end.tv_usec - start.tv_usec;
    printf("diff in microseconds: %i\n", diff);

    float time_per_syscall = diff / 10000.0;

    printf("time per syscall: %f\n", time_per_syscall);
}
