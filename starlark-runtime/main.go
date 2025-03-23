package main

import (
	"fmt"
	"log"

	"go.starlark.net/starlark"
	"go.starlark.net/syntax"
)

var my_object = starlark.NewDict(0)

func main() {
	thread := &starlark.Thread{Name: "main"}

	predeclared := make(starlark.StringDict, 0)
	predeclared["charlie"] = starlark.NewBuiltin("charlie", charlieFunc)

	predeclared["my_object"] = my_object
	predeclared["my_method"] = starlark.NewBuiltin("my_method", myMethodFunc)

	globals, err := starlark.ExecFileOptions(&syntax.FileOptions{}, thread, "main.star", nil, predeclared)
	if err != nil {
		log.Fatalln("failed to execute Starlark program:", err)
	}

	fmt.Println("---end. listing globals---")
	for key, name := range globals {
		fmt.Println(key, "=", name)
	}
}

func charlieFunc(
	thread *starlark.Thread,
	fn *starlark.Builtin,
	args starlark.Tuple,
	kwargs []starlark.Tuple,
) (starlark.Value, error) {
	fmt.Printf("executing function '%s', of type '%s', with receiver '%v' defined in Go\n", fn.Name(), fn.Type(), fn.Receiver())
	return starlark.String("This string was returned from Go!"), nil
}

func myMethodFunc(
	thread *starlark.Thread,
	fn *starlark.Builtin,
	args starlark.Tuple,
	kwargs []starlark.Tuple,
) (starlark.Value, error) {
	fn.BindReceiver(my_object)
	fmt.Printf("executing method '%s', of type '%s', with receiver '%v' defined in Go\n", fn.Name(), fn.Type(), fn.Receiver())
	return starlark.String("This string was returned from Go!"), nil
}
