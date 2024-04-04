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

[docs]: https://github.com/spf13/cobra/blob/v1.8.0/site/content/completions/_index.md
