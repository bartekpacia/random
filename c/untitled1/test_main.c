#include "unity.h"

#define SIZE 11 // from 0 to 10

int wielomian_dodaj(int *, int *);
int wielomian_pomnoz(int *, int *, int *);
int wielomian_drukuj(int *);

void setUp(void) {
}

void tearDown(void) {
}

void test_wielomian_dodaj() {
    // Given
    int akumulator[SIZE] = {1, 0, 2, 0, 0}; // 2x^2 + 1
    int nowy[SIZE] = {-2, 0, 1, 0, 4, 0};   // 4x^4 + 1x^2 - 2

    // When
    wielomian_dodaj(akumulator, nowy);

    // Then
    int expected[SIZE] = {-1, 0, 3, 0, 4, 0}; // 4x^4 + 3x^2 - 1
    TEST_ASSERT_EQUAL_INT_ARRAY(expected, akumulator, SIZE);
}

void test_wielomian_pomnoz() {
    // Given
    int akumulator[SIZE] = {1, 0, 2, 0, 0}; // 2x^2 + 1
    int nowy[SIZE] = {-2, 0, 1, 0, 4, 0};   // 4x^4 + 1x^2 - 2
    int rezultat[SIZE] = {0};

    // When
    wielomian_pomnoz(rezultat, akumulator, nowy);

    // Then
    int expected[SIZE] = {-2, 0, -3, 0, 6, 0, 8, 0}; // 8x^6 + 6x^4 - 3x^2 - 2

    TEST_ASSERT_EQUAL_INT_ARRAY(expected, rezultat, SIZE);
}

int main(void) {
    UNITY_BEGIN();

    RUN_TEST(test_wielomian_dodaj);
    RUN_TEST(test_wielomian_pomnoz);

    return UNITY_END();
}
