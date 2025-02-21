// tick.c
#include <stdio.h>
#include <unistd.h>

int main() {
    for (int i = 0; i < 3; i++) {
        printf("tick\n");
        sleep(1);
    }
}
