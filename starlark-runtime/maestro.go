package main

import (
	"errors"
	"fmt"

	"go.starlark.net/starlark"
)

var errInvalidArguments = errors.New("invalid arguments passed")

var LaunchAppFunc = starlark.NewBuiltin("launch_app", launchAppFunc)

func launchAppFunc(
	thread *starlark.Thread,
	fn *starlark.Builtin,
	args starlark.Tuple,
	kwargs []starlark.Tuple,
) (starlark.Value, error) {
	if len(kwargs) == 0 {
		return nil, errInvalidArguments
	}

	var appID string
	for _, kwarg := range kwargs {
		name := kwarg[0].(string)
		value := kwarg[1].(string)

		if name == "app_id" {
			appID = value
		} else {
			panic("unknown argument not handled")
		}
	}

	if appID == "" {
		appID = thread.Local("app_id").(string)
	}

	if appID == "" {
		return nil, fmt.Errorf("app_id is not specified")
	}

	// return nothing, instead modify internal commands state

	commands = append(commands, map[string]string{
		"launchApp"
	})

	return starlark.None, nil
}
