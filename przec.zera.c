#include <stdio.h>
#define WART_MAX 10
#define WART_MIN -10
#define KONIEC 99
#define TETNO_MAX 14
#define TETNO_MIN 8
#define ROZMIAR_GRUPY 99

int main() {
    int przeciecia_zera;      // liczba przecięć zera
    int x1;      // pierwsza zmienna
    int x2;      // druga zmiena
    int nr = 0;  // numer paczki

    do {
        // zerujemy zmienne
        przeciecia_zera = 0;
        x1 = 0;
        x2 = 0;

        scanf("%d%d", &x1, &x2);
        for (int i = 0; i < ROZMIAR_GRUPY - 2; i++) {
            if (((x1 >= WART_MIN) && (x1 <= WART_MAX)) &&
                ((x2 >= WART_MIN) && (x2 <= WART_MAX))) {
                if (x1 * x2 < 0) {
                    przeciecia_zera++;
                    x2 = x1;
                } else {
                    x2 = x1;
                    scanf("%d", &x1);
                }
            }

            else if (x1 == KONIEC) {
                break;
            }

            scanf("%d", &x1);
        }

        nr++;

        if ((przeciecia_zera >= TETNO_MIN) && (przeciecia_zera <= TETNO_MAX)) {
            printf("wartosc tetna jest prawidlowa w paczce %d i wynosi: %d\n",
                   nr, przeciecia_zera);

        } else {
            printf(
                "wartosc tetna jest nieprawidlowa w paczce %d i wynosi: %d\n",
                nr, przeciecia_zera);
        }

    } while (x1 != KONIEC);

    return 0;
}
