This small Go app is for testing [Cobra's shell completion capabilities][docs].

Build:

```console
$ go build -o go-cobra ./main.go
```

Source completions for the current shell:

```console
$ . <(./go-cobra completion zsh)
```

Test command completion:

```console
$ ./go-cobra r[tab]
completion  -- Generate the autocompletion script for the specified shell
help        -- Help about any command
run         -- Run app on device
```

Test flag completion:

```console
$ ./go-cobra --device [tab]
Barteks-iPhone  emulator-5554
```

# Shell completion – feature overview

To test out various shell completion features, we'll build out a hypothetical simple app for controlling Android
emulators and iOS simulators.

## Complete commands and options

```console
./go-cobra [tab]
```

## Complete single element

Use case: when an option has been selected, don't suggest any more completions.

t=1

```console
$ ./go-cobra run [tab]
Pixel 7 API 34
iPhone 12 mini
iPhone 15
```

t=2

```console
$ ./go-cobra run Pixel\ 7\ API\ 34 [tab] # nothing appears, selection has been made
```

The default Zsh behavior is dependent upon some `zstyle` options. By default, it suggestings files in $pwd.

## Complete finite set of elements

Use case: when a single option is selected, keep suggesting options but exclude the options already
completed/entered/selected.

t=1

```console
$ ./go-cobra run [tab]
Pixel 7 API 34
iPhone 12 mini
iPhone 15
```

t=1

```console
$ ./go-cobra run Pixel 7 API 34 [tab]
iPhone 12 mini
iPhone 15
```

t=2

```console
./go-cobra run Pixel 7 API 34 iPhone 12 mini
```

[docs]: https://github.com/spf13/cobra/blob/v1.8.0/site/content/completions/_index.md


# Debugging

[Cobra docs](https://github.com/spf13/cobra/blob/v1.8.0/site/content/completions/_index.md#debugging)

```console
./go-cobra __complete run ""
Pixel 7 API 34
iPhone 12 mini
iPhone 15
:4
Completion ended with directive: ShellCompDirectiveNoFileComp
```

> ![NOTE]
> The `:4` is [the directive](https://github.com/spf13/cobra/blob/756ba6dad61458cbbf7abecfc502d230574c57d2/completions.go#L43-L44).

```go
cobra.CompDebugln("this string will appear in __complete output", true)
cobra.CompDebugln("this will not appear there", false)
```

To see all traces from Cobra's completion system, set `BASH_COMP_DEBUG_FILE` env
var:

```console
$ export BASH_COMP_DEBUG_FILE="$PWD/cobra.log"
```

# Testing

