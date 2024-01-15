package main

import (
	"fmt"
	"log"

	"go.starlark.net/starlark"
	"go.starlark.net/syntax"
)

func main() {
	thread := &starlark.Thread{Name: "main"}

	predeclared := make(starlark.StringDict, 0)
	predeclared["charlie"] = starlark.NewBuiltin("charlie", charlieFunc)

	globals, err := starlark.ExecFileOptions(&syntax.FileOptions{}, thread, "main.star", nil, predeclared)
	if err != nil {
		log.Fatalln("failed to execute Starlark program:", err)
	}

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
	return starlark.String("Hello from function defined in Go!"), nil
}
