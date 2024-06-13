"""
Autor: Kacper Bohaczyk
Letzte 10 Messungen von einer Wetterstation erhalten
    :@version: 2-Jun-2024
"""
def fibonacci_rekursiv(n):
    """
    Rekursive Variante
    :param n: Wieviele Fibonaccis?
    """
    if n <= 1:
        return n
    else:
        return fibonacci_rekursiv(n-1) + fibonacci_rekursiv(n-2)

def fibonacci_iterativ(n):
    """
    Iterative Variante
    :param n: Wieviele Fibonaccis?
    """
    if n <= 1:
        return n

    aktuell = 0
    naechste_nummer = 1

    # Die n-te Fibonacci-Zahl wird iterativ berechnet
    for _ in range(2, n+1):
        aktuell, naechste_nummer = naechste_nummer, aktuell + naechste_nummer

    return naechste_nummer

def fibonacci_generator():
    """
    Erzeugt alle Fibonacci-Zahlen
    """
    aktuell = 0
    naechste_nummer = 1

    # Theoretisch unendliche Schleife, wird durch yield zum Generator
    while True:
        aktuell, naechste_nummer = naechste_nummer, aktuell + naechste_nummer
        yield aktuell

if __name__ == '__main__':
    def ausfuehren_rekursiv(start, ende):
        ergebnis = []
        for i in range(start, ende + 1):
            ergebnis.append(fibonacci_rekursiv(i))
        return ergebnis

    def ausfuehren_iterativ(start, ende):
        ergebnis = []
        for i in range(start, ende + 1):
            ergebnis.append(fibonacci_iterativ(i))
        return ergebnis

    def ausfuehren_generator(start, ende):
        zahlen = fibonacci_generator()
        # Die ersten Zahlen überspringen
        for _ in range(1, start):
            next(zahlen)

        # Die gewünschten Zahlen entnehmen
        ergebnis = []
        for _ in range(start, ende + 1):
            ergebnis.append(next(zahlen))
        return ergebnis

    # Erwartete Ausgabe: [5, 8, 13, 21, 34, 55]
    print(ausfuehren_rekursiv(5, 10))
    print(ausfuehren_iterativ(5, 10))
    print(ausfuehren_generator(5, 10))

    import timeit

    # timeit.timeit('<code>', number=<iterations>, globals=locals())
    # Führt <code> die gegebene Anzahl an Malen aus. Der Code ist als String angegeben,
    # daher hat er keinen direkten Zugriff auf die Funktionen in dieser Datei.
    # Deshalb wird globals=locals() verwendet: Es gibt Zugriff auf alle Variablen in dieser Datei.
    # Quelle: https://stackoverflow.com/a/1593034/371191

    print("Generator...")
    print(timeit.timeit('ausfuehren_generator(11, 20)', number=1000, globals=locals()))
    print("Iterativ...")
    print(timeit.timeit('ausfuehren_iterativ(11, 20)', number=1000, globals=locals()))
    print("Rekursiv...")
    print(timeit.timeit('ausfuehren_rekursiv(11, 20)', number=1000, globals=locals()))
