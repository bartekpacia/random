#include <stdbool.h>
#include <stdio.h>

#define MAX_DEGREE 10

int wczytaj_liczbe() {
    printf("wczytaj_liczbe\n");
    int liczba = 0;
    int znak = 1;
    bool koniec_wczytywania = false;

    int c = getchar();
    printf("WCZYTANO KURWĘ CHARA %c\n", c);
    while (!koniec_wczytywania) {
        if (c == ' ') {
            c = getchar();
        } else if (c == '-') {
            printf("WCZYTANO KURWA ZNAK MINUSA!\n");
            znak = -1;
            c = getchar();
        } else if (c == '+') {
            c = getchar();
        } else if (c >= '0' && c <= '9') {
            while (c >= '0' && c <= '9') {
                liczba = liczba * 10 + (c - '0');
                c = getchar();
            }
        }
        printf("c not a digit, but %d\n", c);
        ungetc(c, stdin);
        koniec_wczytywania = true;
    }

    // if (liczba == 0) {
    //     liczba = 1;
    // }

    int rezultat = znak * liczba;
    printf("UWAGA ZWRACAM LICZBE %d\n", rezultat);
    return rezultat;
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

void drukuj_wielomian(int wielomian[]) {
    for (int i = MAX_DEGREE; i >= 0; i--) {
        if (wielomian[i] != 0) {
            if (i == 0) {
                printf("%d", wielomian[i]);
            } else if (i == 1) {
                printf("%dx", wielomian[i]);
            } else {
                printf("%dx^%d", wielomian[i], i);
            }

            if (i > 0)
                printf(" + ");
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

int main() {
    setbuf(stdout, NULL);
    int wielomian[MAX_DEGREE + 1] = {0};
    bool koniec_wszystkiego = false; // żeby nie było bandyctwa, żeby nie było złodziejstwa, żeby nie było niczego.
    bool koniec_linii = false;

    while (!koniec_wszystkiego) {
        while (!koniec_linii) {
            const int c = getchar();
            if (c == ' ') {
                // ignorujemy spacje
            } else if (c == '\n') {
                koniec_linii = true;
            } else if (c == '+') {
                dodawanie(wielomian);
            } else if (c == '*') {
                mnozenie(wielomian);
            } else if (c == '.') {
                koniec_wszystkiego = true;
            }
            printf("koniec linii\n");
            drukuj_wielomian(wielomian);
        }
    }

    drukuj_wielomian(wielomian);
    for (int k = 0; k < 11; k++) {
        printf("%d", wielomian[k]);
    }

    return 0;
}
