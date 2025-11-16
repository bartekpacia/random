#include <stdbool.h>
#include <stdio.h>

#define MAX_DEGREE 10

int wczytaj_liczbe() {
    printf("wczytaj_liczbe: start\n");
    int liczba = 0;
    int znak = 1;
    bool koniec_wczytywania = false;

    int c = getchar();
    printf("wczytaj_liczbe: wczytano pierwszy znak %c\n", c);
    while (!koniec_wczytywania) {
        if (c == ' ') {
            c = getchar();
        } else if (c == '-') {
            printf("wczytaj_liczbe: wczytano znak minus\n");
            znak = -1;
            c = getchar();
        } else if (c == '+') {
            printf("wczytaj_liczbe: wczytano znak plus\n");
            c = getchar();
        } else if (c >= '0' && c <= '9') {
            while (c >= '0' && c <= '9') {
                liczba = liczba * 10 + (c - '0');
                c = getchar();
            }
            printf("wczytaj_liczbe: wczytano liczbe %d, koniec wczytywania\n", liczba);
            koniec_wczytywania = true;
        } else if (c == 'x') {
            printf("wczytaj_liczbe: wczytano znak x\n");
            if (liczba == 0) {
                printf("wczytaj_liczbe: wczytano znak x, a nie było przed nim liczby, wiec ustawiono liczbe na 1\n");
                liczba = 1;
            }
            koniec_wczytywania = true;
            ungetc(c, stdin);
        }
        // printf("c is not a digit, but: d = %d, c = %c\n", c, c);
        // ungetc(c, stdin);
        // koniec_wczytywania = true;
    }

    // TODO: o
    // if (liczba == 0) {
    //     liczba = 1;
    // }

    printf("wczytaj_liczbe: RETURN! znak = %d, liczba = %d\n", znak, liczba);
    int nextChar = getchar();
    printf("wczytaj_liczbe: nastepny char to będzie %c\n", nextChar);
    ungetc(nextChar, stdin);
    return znak * liczba;
}

int wczytaj_wykladnik() {
    printf("wczytaj_wykladnik\n");
    int wykl = 0;
    int c = getchar();

    if (c == 'x') {
        c = getchar();
        while (c == ' ') {
            c = getchar(); // potem spacje po ^ pomija dzieki funkcji wczytaj liczbe
        }
        if (c == '^') {
            wykl = wczytaj_liczbe();
        } else {
            wykl = 1;
            ungetc(c, stdin); // zwracamy znak do bufora ?????
        }
    } else {
        wykl = 0;
        ungetc(c, stdin);
    }
    return wykl;
}

void dodaj_jednomian(int wielomian[]) {
    printf("dodaj_jednomian\n");
    int wspolczynnik = wczytaj_liczbe();
    int wykladnik = wczytaj_wykladnik();
    wielomian[wykladnik] += wspolczynnik;
}

void dodawanie(int wielomian[]) {
    printf("dodawanie");
    bool koniec = false;
    while (!koniec) {
        const int c = getchar();
        if (c == ' ') {
            // ignorujemy spację
        } else if (c == '\n') {
            koniec = true;
            ungetc(c, stdin); // kod wyżej oczekuje nowej linii
        } else {
            ungetc(c, stdin); // kod niżej chce ten znak!
            dodaj_jednomian(wielomian);
        }
    }

    // while (c != '\n') {
    //     if (c != ' ') {
    //         ungetc(c, stdin);
    //         dodaj_jednomian(wielomian);
    //     }
    //     c = getchar();
    // }
}

void mnozenie(int wielomian[]) {
    printf("mnozenie\n");
    int temp[MAX_DEGREE + 1] = {0};
    int c = getchar();

    while (c == ' ') {
        c = getchar(); // pomijamy spacje
    }
    ungetc(c, stdin);

    int wspolczynnik = wczytaj_liczbe(); // for 21x^37, will return 21
    printf("wczytano wspolczynnik: %d\n", wspolczynnik);
    int wykladnik = wczytaj_wykladnik(); // for 21x^37, will return 37
    printf("wczytano wykladnik: %d\n", wykladnik);

    for (int i = 0; i <= MAX_DEGREE; i++) {
        if (wielomian[i] != 0) {
            int nowy_wykl = i + wykladnik;
            if (nowy_wykl <= MAX_DEGREE)
                temp[nowy_wykl] += wielomian[i] * wspolczynnik;
        }
    }
    for (int i = 0; i <= MAX_DEGREE; i++)
        wielomian[i] = temp[i];

    // pomiń resztę linii
    while (getchar() != '\n')
        ;
}

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

// void debug_drukuj_wielomian(int wielomian[]) {
//     printf("-- debug start --\n");
//     printf("  wielomian: [");
//     for (int i = 0; i <= MAX_DEGREE; i++) {
//         printf("   %d", wielomian[i]);
//     }
//     printf("]\n");
//     printf("  indeksy:   [");
//     for (int i = 0; i <= MAX_DEGREE; i++) {
//         printf("   %d", i);
//     }
//     printf("]\n");
//     printf("-- debug end --\n");
// }

void parse_wielomian(int *wielomian) {
    int c;
    while ((c = getchar()) != '\n') {
        if (c != ' ') {
            printf("%c", c);
        }
    }

    wielomian[0] = 2137;

    printf("\n");
}

void skip_spaces() {
    int c = getchar();
    while (c == ' ') {
        c = getchar(); // pomijamy spacje pomiędzy pierwszym znakiem (znakiem operacji) a początkiem wielomianu
    }
    ungetc(c, stdin); // ostatnio wczytany znak nie był spacją, a więc zwróćmy go
}

void wielomian_dodaj(int akumulator[], int nowy[]) {
    for (int i = 0; i <= MAX_DEGREE; i++) {
        akumulator[i] += nowy[i];
    }
}

void wielomian_pomnoz(int akumulator[], int nowy[]) {
    int akumulator_new[MAX_DEGREE + 1] = {0};
    for (int i = 0; i < MAX_DEGREE + 1; i++) {
        // akumulator_new[i] = akumulator[i];
    }

    for (int i = MAX_DEGREE; i >= 0; i--) {
        if (akumulator[i] != 0) {
            int tymczasowy[MAX_DEGREE + 1] = {0};
            for (int j = MAX_DEGREE; j >= 0; j--) {
                if (nowy[j] != 0) {
                    const int stopien = i + j;
                    const int wspolczynnik = akumulator[i] * nowy[j];
                    printf("mnożymy: %dx^%d * %dx^%d = %dx^%d\n", akumulator[i], i, nowy[j], j, wspolczynnik, stopien);
                    tymczasowy[stopien] = wspolczynnik;
                }
            }
            printf("---> START\n");
            printf("akumulator_new: \n");
            wielomian_drukuj(akumulator_new);
            printf("tymczasowy:\n");
            wielomian_drukuj(tymczasowy);
            wielomian_dodaj(akumulator_new, tymczasowy);
            printf("po dodaniu ich obu:\n");
            wielomian_drukuj(akumulator_new);
            printf("---> END\n");
        }
    }

    wielomian_dodaj(akumulator, akumulator_new);
    for (int i = 0; i < MAX_DEGREE + 1; i++) {
        akumulator[i] = akumulator_new[i];
    }
    // wielomian_dodaj(akumulator, akumulator_new);
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
        int c = getchar();

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
        }

        if (op == OP_DODAWANIE) {
            wielomian_dodaj(akumulator, wielomian);
        } else if (op == OP_MNOZENIE) {
            // mnozenie(akumulator);
        } else {
            koniec_wszystkiego = true;
        }
    }

    wielomian_drukuj(akumulator);
    for (int k = 0; k < 11; k++) {
        printf("%d", akumulator[k]);
    }

    return 0;
}
#endif
