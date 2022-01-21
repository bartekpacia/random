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

void insert_sort(int* array, int length) {
    int i, j;
    for (i = 1; i < length; ++i) {
        int value = array[i];
        for (j = i - 1; j >= 0 && array[j] > array[i]; --j) {
            array[j + 1] = array[j];
        }
        array[j + 1] = value;
    }
}

int main() {
    int length = 9;
    int arr[] = {7, 4, 2, 6, 3, 1, 8, 9, 5};
    insert_sort(arr, length);

    for (int i = 0; i < length; i++) {
        printf("%i ", arr[i]);
    }

    printf("\n");
}
