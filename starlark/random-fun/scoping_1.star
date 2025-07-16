# y = "goodbye"

def hello():
  for x in (1, 2):
    print("x: {}: y = {}" % (x, y))
    if x == 2:
      print(y) # prints "hello"
    if x == 1:
      y = "hello"

hello()
