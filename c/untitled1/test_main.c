#include "unity.h"

#define SIZE 11 // from 0 to 10

int wielomian_dodaj(int *, int *);

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

    TEST_ASSERT_EQUAL_INT_ARRAY(akumulator, expected, SIZE);
}

int main(void) {
    UNITY_BEGIN();

    RUN_TEST(test_wielomian_dodaj);

    return UNITY_END();
}
