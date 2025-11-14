#include <stdio.h>

#define MAX_DEGREE 10

int wczytaj_liczbe() {
    int liczba = 0;
    int znak = 1;
    int c = getchar();
    int koniec_wczytywania = 0;

while (koniec_wczytywania == 0) {
    if (c == ' ') {
        c = getchar();
    } else if (c == '-') {
        znak = -1;
        c = getchar();
    } else if (c == '+') {
        c = getchar();
    } else if (c >= '0' && c <= '9') {
        while (c >= '0' && c <= '9') {
            liczba = liczba * 10 + (c - '0');
            c = getchar();
        }
        ungetc(c, stdin);
        koniec_wczytywania = 1;
    }
}
    return znak * liczba;
}

int wczytaj_wykladnik() {
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
    int wsp = wczytaj_liczbe();
    int wykl = wczytaj_wykladnik();
    wielomian[wykl] += wsp;
}

void dodawanie(int wielomian[]) {
    int c = getchar();
    while (c != '\n') {
        if (c != ' ') {
            ungetc(c, stdin);
            dodaj_jednomian(wielomian);
        }
        c = getchar();
    }
}

// void mnozenie(int wielomian[]) {
//     int temp[MAX_DEGREE+1] = {0};
//     int c = getchar();
//
//     while (c == ' ') c = getchar(); // pomijamy spacje
//     ungetc(c, stdin);
//
//     int wsp = wczytaj_liczbe();
//     int wykl = wczytaj_wykladnik();
//
//     for (int i=0; i<=MAX_DEGREE; i++) {
//         if (wielomian[i] != 0) {
//             int nowy_wykl = i + wykl;
//             if (nowy_wykl <= MAX_DEGREE)
//                 temp[nowy_wykl] += wielomian[i] * wsp;
//         }
//     }
//     for (int i=0; i<=MAX_DEGREE; i++)
//         wielomian[i] = temp[i];
//
//     // pomiń resztę linii
//     while ((c = getchar()) != '\n');
// }

// void drukuj_wielomian(int wielomian[]) {
//     for (int i=MAX_DEGREE; i>=0; i--) {
//         if (wielomian[i] != 0) {
//             if (i == 0) printf("%d", wielomian[i]);
//             else if (i == 1) printf("%dx", wielomian[i]);
//             else printf("%dx^%d", wielomian[i], i);
//
//             if (i > 0) printf(" + ");
//         }
//     }
//     printf("\n");
// }

int main() {
    int wielomian[MAX_DEGREE+1] = {0};
    int c = getchar();
    int koniec = 0;

    while (!koniec) {
        if (c == ' ' || c == '\n') {
            c = getchar();
        } else if (c == '+') {
            dodawanie(wielomian);
        } else if (c == '*') {
            // mnozenie(wielomian);
        } else if (c == '.') {
            koniec = 1;
            // while ((c = getchar()) != '\n'); // pomiń resztę linii po kropce
            // }
            // if (!koniec) c = getchar();
        }
    }
        // drukuj_wielomian(wielomian);
    for (int k = 0; k < 11; k++) {
        printf("%d",wielomian[k]);
    }
    return 0;
}

