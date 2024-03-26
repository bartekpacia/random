def fun1c():
    l = [(1, 2), (3, 4), (5, 6)]
    d = {("a", "b"): 1, ("c", "d"): 2, ("e", "f"): 3}
    for i, (key_1, key_2) in enumerate(d):
        print("i: %s, key_1: %s, key_2: %s, value: %s" % (i, key_1, key_2, d[(key_1, key_2)]))

    print("i value is %s" % i)

# func1()


def func(arg, *args, **kwargs):
	print("arg: %s, type: %s" % (arg, type(arg)))
	print("args: %s, type: %s" % (args, type(args)))
	print("kwargs: %s, type: %s" % (kwargs, type(kwargs)))
	

arg = "a"
args = ["b", "c"]
kwargs = {"d": 4, "e": 5}

func(arg, *args, **kwargs)

#args = [2, 3, 4]
#func2(1, args)
#func2(1, 2, 3, 4)
