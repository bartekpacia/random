class SomeObj:
  
  def __repr__(self):
    return "SomeObj repr!!!"

  def __str__(self):
    return "SomeObj str!!!"

a = [1, 2, SomeObj(), str(SomeObj())]
print(a)
