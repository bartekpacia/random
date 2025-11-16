#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_DEGREE 10

void wielomian_drukuj(int wielomian[]) {
    for (int i = MAX_DEGREE; i >= 0; i--) {
        if (wielomian[i] != 0) {
            if (i == 0) {
                printf("%d", wielomian[i]);
            } else if (i == 1) {
                printf("%dx", wielomian[i]);
            } else {
                printf("%dx^%d", wielomian[i], i);
            }
            if (i > 0) {
                printf(" + ");
            }
        }
    }
    printf("\n");
}

int parse_cyfra_od_2_do_9(int c) {
    int digit = c - '0';
    if (digit < 2 || digit > 9) {
        digit = -1;
    }
    return digit;
}

int parse_cyfra() {
    int cyfra;
    const int c = getchar();
    if (c == '0') {
        cyfra = 0;
    } else if (c == '1') {
        cyfra = 1;
    } else {
        cyfra = parse_cyfra_od_2_do_9(c);
        if (cyfra == -1) {
            cyfra = -1;
            ungetc(c, stdin);
        }
    }
    return cyfra;
}

int parse_duzo() {
    int liczba = -2137;
    const int c = getchar();
    if (c == '1') {
        liczba = 1;
        int cyfra;
        while ((cyfra = parse_cyfra()) != -1) {
            liczba *= 10;
            liczba += cyfra;
        }
    } else {
        int cyfra = parse_cyfra_od_2_do_9(c);
        if (cyfra == -1) {
            liczba = -1;
            ungetc(c, stdin);
        } else {
            liczba = cyfra;
            while ((cyfra = parse_cyfra()) != -1) {
                liczba *= 10;
                liczba += cyfra;
            }
        }
    }
    return liczba;
}

void parse_jednomian(int *wspolczynnik, int *wykladnik) {
    printf("  2. begin parsing jednomian...\n");
    // Możliwe 3 formy jednomianu:
    //  1: 1 (po prostu jedynka)
    //  2: 2137 <dużo> (same cyfry)
    //  3a: 2137x <dużo> "x"
    //  3b: x^2 ("x" "^" <dużo>
    //  3c: 2137x^2 (<dużo> "x" "^" <dużo>

    int c = getchar();
    if (c == '1') {
        *wspolczynnik = 1;
        *wykladnik = 0;

        // int cyfra = parse_cyfra();
        // if (cyfra == -1) {
        //     printf("ERROR: cyfra jest %d\n", cyfra);
        //     exit(1);
        // }
        //
        // while ((cyfra = parse_cyfra()) != -1) {
        //     *wspolczynnik *= 10;
        //     *wspolczynnik += cyfra;
        // }
    } else {
        ungetc(c, stdin);
        const int duzo = parse_duzo();
        if (duzo == -1) {
            printf("ERROR: duzo nie moze byc tutaj -1\n");
            exit(1);
        }
        *wspolczynnik = duzo;
        *wykladnik = 0;

        c = getchar();
        if (c == 'x') {
            *wykladnik = 1;
            c = getchar();
            if (c == '^') {
                const int wykl = parse_duzo();
                if (wykl != -1) {
                    *wykladnik = wykl;
                }
            } else {
                ungetc(c, stdin);
            }

        } else {
            ungetc(c, stdin);
        }
    }
}

int parse_operacja() {
    int op;
    const int c = getchar();
    if (c == '+') {
        op = '+';
    } else if (c == '-') {
        op = '-';
    } else {
        op = -1;
        ungetc(c, stdin);
    }
    return op;
}

void parse_wielomian(int *wielomian) {
    printf("1. begin parsing wielomian...\n");
    const int c = getchar();
    if (c == '0') {
        wielomian[0] = 0; // this line is probably redundant too
    } else {
        int znak_pierwszego_jednomianu = 1;
        if (c == '-') {
            znak_pierwszego_jednomianu = -1;
        } else {
            ungetc(c, stdin);
        }

        int wspolczynnik = 0;
        int wykladnik = 0;
        parse_jednomian(&wspolczynnik, &wykladnik);
        wielomian[wykladnik] = znak_pierwszego_jednomianu * wspolczynnik;

        int op;
        while ((op = parse_operacja()) != -1) {
            parse_jednomian(&wspolczynnik, &wykladnik);
            if (op == '-') {
                wielomian[wykladnik] = -wspolczynnik;
            } else if (op == '+') {
                wielomian[wykladnik] += wspolczynnik;
            } else {
                printf("niepoprawna operacja: %d\n", op);
                exit(1);
            }
        }
    }
}

void skip_spaces() {
    int c = getchar();
    while (c == ' ') {
        c = getchar(); // pomijamy spacje pomiędzy pierwszym znakiem (znakiem operacji) a początkiem wielomianu
    }
    ungetc(c, stdin); // ostatnio wczytany znak nie był spacją, a więc zwróćmy go
}

void wielomian_dodaj(int akumulator[], const int nowy[]) {
    for (int i = 0; i <= MAX_DEGREE; i++) {
        akumulator[i] += nowy[i];
    }
}

void wielomian_pomnoz(int output[], int akumulator[], int nowy[]) {
    int delta[MAX_DEGREE + 1] = {0};

    for (int i = MAX_DEGREE; i >= 0; i--) {
        if (akumulator[i] != 0) {
            int tymczasowy[MAX_DEGREE + 1] = {0};
            printf("---> START\n");
            for (int j = MAX_DEGREE; j >= 0; j--) {
                if (nowy[j] != 0) {
                    const int stopien = i + j;
                    const int wspolczynnik = akumulator[i] * nowy[j];
                    printf("mnożymy: %dx^%d * %dx^%d = %dx^%d\n", akumulator[i], i, nowy[j], j, wspolczynnik, stopien);
                    tymczasowy[stopien] = wspolczynnik;
                }
            }
            printf("akumulator_new: \n");
            wielomian_drukuj(delta);
            printf("tymczasowy:\n");
            wielomian_drukuj(tymczasowy);
            wielomian_dodaj(delta, tymczasowy);
            printf("po dodaniu ich obu:\n");
            wielomian_drukuj(delta);
            printf("---> END\n");
        }
    }

    wielomian_dodaj(akumulator, delta);
    for (int i = 0; i < MAX_DEGREE + 1; i++) {
        output[i] = delta[i];
    }
}

#define OP_DODAWANIE 1
#define OP_MNOZENIE 2
#define OP_KONIEC 3

#ifndef TESTING
int main() {
    setbuf(stdout, NULL);
    int akumulator[MAX_DEGREE + 1] = {0};
    bool koniec_wszystkiego = false;

    while (!koniec_wszystkiego) {
        int op = -1; // 1 = dodawanie, 2 = mnożenie, 3 = koniec
        const int c = getchar();
        int wielomian[MAX_DEGREE + 1] = {0};
        if (c == '+') {
            op = OP_DODAWANIE;
            skip_spaces();
            parse_wielomian(wielomian);
        } else if (c == '*') {
            op = OP_MNOZENIE;
            skip_spaces();
            parse_wielomian(wielomian);
        } else if (c == '.') {
            op = OP_KONIEC;
        } else if (c == '\n') {
            // kontynuuj do nowej linii
        } else {
            printf("niepoprawny znak początku linii: %c\n", c);
            exit(1);
        }

        if (op == OP_DODAWANIE) {
            wielomian_dodaj(akumulator, wielomian);
        } else if (op == OP_MNOZENIE) {
            int rezultat_mnozenia[MAX_DEGREE + 1] = {0};
            wielomian_pomnoz(rezultat_mnozenia, akumulator, wielomian);
            wielomian_dodaj(akumulator, rezultat_mnozenia);
        } else if (op == OP_KONIEC) {
            koniec_wszystkiego = true;
        }
    }

    printf("koniec...\n");
    wielomian_drukuj(akumulator);
    for (int k = 0; k < 11; k++) {
        printf("%d", akumulator[k]);
    }

    return 0;
}
#endif
