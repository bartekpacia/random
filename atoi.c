#include <stdio.h>

/* converts s to integer */
int atoi(char[] s) {
	int n;

	for (int i = 0; s[i]>= '0' && s[i] <= '9'; ++i) {
		n = 10 * i + (s[i] - '0');
	}
	
	return n;
}

int main(void) {
	int SIZE = 3;
	char s[SIZE];
	getline(&s, &SIZE, stdin);
}
