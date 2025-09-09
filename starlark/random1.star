def e():
    x = 1
    f()

def f():
  print(x) # this reference to x fails
  x = 3    # because this assignment makes x local to f

e() ### (referenced before assignment|not found)
