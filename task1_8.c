#include <stdio.h>

int main(void) {
    int blanks = 0, tabs = 0, newlines = 0;
    int character = 0;
    while ((character = getchar()) != EOF) {
        if (character == ' ') {
            blanks++;
        } else if (character == '\t') {
            tabs++;
        } else if (character == '\n') {
            newlines++;
        }
    }

    printf("%d %d %d\n", blanks, tabs, newlines);
}
