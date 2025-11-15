# The great trove of shell completion knowledge

This memo is Zsh-focused because I'm a user of Zsh.

Some resources (might be useful):
- https://github.com/ohmyzsh/ohmyzsh/wiki/Design
- https://github.com/ohmyzsh/ohmyzsh/wiki/Settings
- [ZSH Documentation](https://zsh.sourceforge.io/Doc)
  - [18 Zsh Line Editor](https://zsh.sourceforge.io/Doc/Release/Zsh-Line-Editor.html#Zsh-Line-Editor)
    - [18.4 Zle Widgets](https://zsh.sourceforge.io/Doc/Release/Zsh-Line-Editor.html#Zle-Widgets)
  - [19 Completion Widgets](https://zsh.sourceforge.io/Doc/Release/Completion-Widgets.html#Completion-Widgets)
  - [20 Completion System](https://zsh.sourceforge.io/Doc/Release/Completion-System.html#Completion-System)
- [A User's Guide to the Z-Shell](https://zsh.sourceforge.io/Guide)
  - in particular: [Chapter 6: Completion, old and new](https://zsh.sourceforge.io/Guide/zshguide06.html#l144)
- [Z-Shell Frequently-Asked Questions](https://zsh.sourceforge.io/FAQ)
  - in particular: [Chapter 4: The mysteries of completion](https://zsh.sourceforge.io/FAQ/zshfaq04.html#l49)

Zsh has two completion systems: compsys is new, compctl is old.

See manpages:
- `zshcompwid(1)` - zsh completion widgets
- `zshcompsys(1)` - zsh completion system
- ~`zshcompctl(1)` - zsh programmable completion~ (old!)

# The sample app

Let's introduce a simple helper program for managing iOS simulators and Android emulators called `emux`
(it's based on a real [emu](https://github.com/bartekpacia/emu), but it doesn't matter here).

`emux` is interesting from the shell completion perspective.

`emux` has two variants -
one using [spf13/cobra](https://github.com/spf13/cobra) (`emux-cobra`), and one using [urfave/cli](https://github.com/urfave/cli) (`emux-cli`).

The aim is to look at how shell completion works in the spf13/cobra variant,
so we can improve the urfave/cli variant.

This small Go app is for testing [Cobra's shell completion capabilities][docs].

Build:

```console
$ go build -o emux-cli ./cmd/emux-cli # build CLI using urfave/cli
$ go build -o emux-cobra ./cmd/emux-cobra # build CLI using spf13/cobra
```

Source completions for the current shell:

```console
$ . <(./emux-cli completion zsh)
$ . <(./emux-cobra completion zsh)
```

Test command completion:

```console
$ ./emux-cli r[tab]
completion  -- Generate the autocompletion script for the specified shell
help        -- Help about any command
run         -- Run app on device
```

Test flag completion:

```console
$ ./emux-cli --device [tab]
Barteks-iPhone  emulator-5554
```

# Shell completion in spf13/cobra – feature overview

To test out various shell completion features, we'll build out a hypothetical simple app for controlling Android
emulators and iOS simulators.

## Examples

### Complete commands

t=1

```console
$ ./emux-cli [tab]
create  -- Create a new device
kill    -- Kill a single device
run     -- Start a single device
runall  -- Start many devices
```

t=1

```console
$ ./emux-cli r[tab]
run     -- Start a single device
runall  -- Start many devices
```

### Complete a single command argument

Use case: when an option has been selected, don't suggest any more completions.

t=1

```console
$ ./emux-cli run [tab]
Pixel 7 API 34
iPhone 12 mini
iPhone 15
```

t=2

```console
$ ./emux-cli run Pixel\ 7\ API\ 34 [tab] # nothing appears, selection has been made
```

The default Zsh behavior is dependent upon some `zstyle` options. By default, it suggests files in $pwd.

### Complete single element (with flags)

Similar to the previous one, but should suggest subcommand's flags instead when user's entry
starts with `-` or `--`.

t=1

```console
$ ./emux-cli run --[tab]
--fast
--slow
```

t=2

```console
$ ./emux-cli run --fast [tab]
Pixel 7 API 34
iPhone 12 mini
iPhone 15
```

### Complete finite set of elements

Use case: when a single option is selected, keep suggesting options but exclude the options already
completed/entered/selected.

t=1

```console
$ ./emux-cli run [tab]
Pixel 7 API 34
iPhone 12 mini
iPhone 15
```

t=1

```console
$ ./emux-cli run Pixel 7 API 34 [tab]
iPhone 12 mini
iPhone 15
```

t=2

```console
./emux-cli run Pixel 7 API 34 iPhone 12 mini
```

### Complete a single value for a flag element (with flags)

Similar to the previous one, but in this case (when current arguments starts
with `-` or `--`) we want to suggests the values available for a particular
flag.

```console
$ TODO: invent some example (e.g. --device [value])
```

[docs]: https://github.com/spf13/cobra/blob/v1.8.0/site/content/completions/_index.md

## Debugging

[Cobra docs](https://github.com/spf13/cobra/blob/v1.8.0/site/content/completions/_index.md#debugging)

```console
./emux-cli __complete run ""
Pixel 7 API 34
iPhone 12 mini
iPhone 15
:4
Completion ended with directive: ShellCompDirectiveNoFileComp
```

> [!NOTE]
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

## Testing

# Shell completion in urfave/cli

To enable debug logging:

```console
$ export URFAVE_CLI_TRACING=on
```

## The plan

API changes:

- Add `cli.ShellCompleteFunc` func type, same as in cobra


**Decision to be made**

Does `urfave/cli` migrate to hidden `__complete` command,
or does it keep `--generate-shell-completion` arg?


- This is quite hard, writing tests first is probably good idea. Take a look at
  how shell completion is tested in Cobra.
