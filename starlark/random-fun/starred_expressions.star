def func(arg, *args, **kwargs):
	print("arg: %s, type: %s" % (arg, type(arg)))
	print("args: %s, type: %s" % (args, type(args)))
	print("kwargs: %s, type: %s" % (kwargs, type(kwargs)))

arg = "a"
args = ["b", "c"]
kwargs = {"d": 4, "e": 5}

print("\n--- NOT using starred expressions ---\n")
func(arg, args, kwargs)

print("\n--- Using starred expressions ---\n")
func(arg, *args, **kwargs)

dict = {"key": "key_value"}

env = {
	**dict,
	"xd": "dupa",
}

print(env)
