# From https://docs.python.org/3/reference/executionmodel.html#interaction-with-dynamic-features

i = 10
def f():
    print(i)
i = 42
f()
