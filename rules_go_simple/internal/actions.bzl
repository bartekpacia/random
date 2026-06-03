load("@bazel_skylib//lib:shell.bzl", "shell")

def go_compile(ctx, *, srcs, importpath, out):
    """Compiles a single Go package from sources
    

    Args:
        ctx: analysis context.
        srcs: list of source Files to be compiled.
        importpath: the path other libraries may use to import this package.
        out: output .a File.    
    """

    cmd = r"""
    gocache=$(mktemp -d)
    importcfg=$(mktemp)
    GOCACHE="$gocache" go list -export -deps -f '{{{{if .Export}}}}packagefile {{{{.ImportPath}}}}={{{{.Export}}}}{{{{end}}}}' -- {srcs} >"$importcfg"
    GOCACHE="$gocache" go tool compile -o {out} -p {importpath} -importcfg "$importcfg" -- {srcs}
    """.format(
        out = shell.quote(out.path),
        importpath = shell.quote(importpath),
        srcs = " ".join([shell.quote(src.path) for src in srcs]),
    )

    ctx.actions.run_shell(
        mnemonic = "GoCompile",
        outputs = [out],
        inputs = srcs,
        command = cmd,
        env = {"GOPATH": "/dev/null"},
        use_default_shell_env = True,
    )

def go_link(ctx, *, main, srcs, out):
    """Links a Go executable.

    Args:
        ctx: analysis context.
        main: archive file for the main package.
        srcs: list of source Files for the main package.
        out: output executable file.
    """

    cmd = r"""
    gocache=$(mktemp -d)
    importcfg=$(mktemp)
    GOCACHE="$gocache" go list -export -deps -f '{{{{if .Export}}}}packagefile {{{{.ImportPath}}}}={{{{.Export}}}}{{{{end}}}}' -- {srcs} >"$importcfg"
    GOCACHE="$gocache" go tool link -o {out} -importcfg "$importcfg" -- {main}
    """.format(
        main = shell.quote(main.path),
        out = shell.quote(out.path),
        srcs = " ".join([shell.quote(src.path) for src in srcs]),
    )

    ctx.actions.run_shell(
        mnemonic = "GoLink",
        outputs = [out],
        inputs = [main] + srcs,
        command = cmd,
        env = {"GOPATH": "/dev/null"},
        use_default_shell_env = True,
    )
