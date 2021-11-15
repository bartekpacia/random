#include <iostream>

using namespace std;

int main() {
    const int wartosc = 15;
    const int* wsk = &wartosc;

    // int* wsk2 = wsk;

    int* nowyWsk = const_cast<int*>(wsk);
}
