def fib_recursive(n):
    # TODO return a single fibonacci number
    pass

def fib_iterative(n):
    # TODO return a single fibonacci number
    pass

def fib_generator():
    # TODO generate all finonacci numbers
    pass

if __name__ == '__main__':
    def run_recursive(start, end):
        result = []
        for i in range(start, end + 1):
            result.append(fib_recursive(i))
        return result

    def run_iterative(start, end):
        result = []
        for i in range(start, end + 1):
            result.append(fib_iterative(i))
        return result

    def run_generator(start, end):
        numbers = fib_generator()
        # skip the first few numbers
        for i in range(1, start):
            next(numbers)

        # take the numbers we want
        result = []
        for i in range(start, end + 1):
            result.append(next(numbers))
        return result

    # expected output: [5, 8, 13, 21, 34, 55]
    print(run_recursive(5, 10))
    print(run_iterative(5, 10))
    print(run_generator(5, 10))


    import timeit

    # timeit.timeit('<code>', number=<iterations>, globals=locals())
    # runs <code> the given number of time. The code is given as a string,
    # so it does not have access to the functions defined in this file implicitly.
    # This is why globals=locals() is given: it gives access to all variables in this file.
    # Source: https://stackoverflow.com/a/1593034/371191

    print("Generator...")
    print(timeit.timeit('run_generator(11, 20)', number=1000, globals=locals()))
    print("Iterative...")
    print(timeit.timeit('run_iterative(11, 20)', number=1000, globals=locals()))
    print("Recursive...")
    print(timeit.timeit('run_recursive(11, 20)', number=1000, globals=locals()))
