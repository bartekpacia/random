#include <stdio.h>

void swap(int* first, int* second) {
    int temp = *first;
    *first = *second;
    *second = temp;
}

int partition(int* arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

/// Sortuje tablicę "array" o długości "length" metodą szybkiego sortowania.
void quick_sort(int* arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quick_sort(arr, low, pi - 1);
        quick_sort(arr, pi + 1, high);
    }
}

int main() {
    int length = 9;
    int arr[] = {7, 4, 2, 6, 3, 1, 8, 9, 5};
    quick_sort(arr, 0, length);

    for (int i = 0; i < length; i++) {
        printf("%i ", arr[i]);
    }

    printf("\n");
}
