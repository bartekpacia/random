liczba = int(input("podaj liczbę: "))
wielokrotnosc = int(input("podaj wielokrotność: "))

for i in range(1, wielokrotnosc + 1):
    print(f"{i}: {i * liczba}")
