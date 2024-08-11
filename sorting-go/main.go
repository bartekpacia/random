package main

import "fmt"

func main() {
	array := []int{2, 8, 5, 3, 9, 4}

	insertionSort(array)

	fmt.Println(array)
}

func insertionSort(arr []int) {
	if len(arr) < 2 {
		return
	}

	for i := 1; i < len(arr); i++ {
		for j := i; j > 0 && arr[j] < arr[j-1]; j-- {
			tmp := arr[j-1]
			arr[j-1] = arr[j]
			arr[j] = tmp
		}
	}
}
