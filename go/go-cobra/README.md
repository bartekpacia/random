This small Go app is for testing [Cobra's shell completion capabilities][docs].

Build:

```console
go build -o go-cobra ./main.go
```

Source completions for the current shell:

```console
. <(./go-cobra completion zsh)
```

Test argument completion:

```console
./go-cobra r[tab]
completion  -- Generate the autocompletion script for the specified shell
help        -- Help about any command
run         -- Run app on device
```

Test flag completion:

```console
./go-cobra --device [tab]
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
./go-cobra run [tab]
Pixel 7 API 34
iPhone 12 mini
iPhone 15
```

t=2

```console
./go-cobra run Pixel\ 7\ API\ 34 [tab] # nothing appears, selection has been made
```

The default Zsh behavior is dependent upon some `zstyle` options. By default, it suggestings files in $pwd.

## Complete finite set of elements

Use case: when a single option is selected, keep suggesting options but exclude the options already
completed/entered/selected.

t=1

```console
./go-cobra run [tab]
Pixel 7 API 34
iPhone 12 mini
iPhone 15
```

t=1

```console
./go-cobra run Pixel 7 API 34 [tab]
iPhone 12 mini
iPhone 15
```

t=2

```console
./go-cobra run Pixel 7 API 34 iPhone 12 mini
```

[docs]: https://github.com/spf13/cobra/blob/v1.8.0/site/content/completions/_index.md
