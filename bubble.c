#include <stdio.h>

/// Sortuje tablicę "array" o długości "length" metodą bąbelkową.
void bubble_sort(int* array, int length) {
    for (int i = 0; i < length - 1; i++) {
        for (int j = 0; j < length - 1; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = temp;
            }
        }
    }
}

int main() {
    int length = 9;
    int arr[] = {7, 4, 2, 6, 3, 1, 8, 9, 5};
    bubble_sort(arr, length);

    for (int i = 0; i < length; i++) {
        printf("%i ", arr[i]);
    }

    printf("\n");

    int length2 = 100000;
    int arr2[100000];

    for (int i = 99999; i >= 0; i--) {
        arr2[100000 - i] = i;
    }

    bubble_sort(arr2, length2);

    for (int i = 0; i < length2; i++) {
        printf("%i ", arr2[i]);
    }

    printf("\n");
}
