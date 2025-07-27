from time import sleep

def three_numbers():
    print("first")
    yield 1
    print("second")
    yield 2
    print("and... ")
    sleep(1)
    print("third!")
    yield 3


if __name__ == '__main__':
    print("a generator function returns a generator object")
    print(three_numbers())
    print("not even 'first' was printed")

    print("generator objects can be iterated, running part of the function on-demand")
    for num in three_numbers():
        print(num)

    print("if we stop iterating, we don't run the rest of the function")
    for num in three_numbers():
        print(num)
        break  # stopping early
