load("//internal:actions.bzl", "go_compile", "go_link")

def _go_binary_impl(ctx):
    # Declare an output file for the main package and compile it from srcs.
    main_archive = ctx.actions.declare_file("{name}.a".format(name = ctx.label.name))
    go_compile(
        ctx,
        srcs = ctx.files.srcs,
        importpath = "main",
        out = main_archive,
    )

    # Declare an output file for the executable and link it.
    executable = ctx.actions.declare_file(ctx.label.name)
    go_link(
        ctx,
        main = main_archive,
        srcs = ctx.files.srcs,
        out = executable,
    )

    # Return the DefaultInfo provider.
    # This tells Bazel what files should be built when someone asks to build a go_binary rule.
    # It also says which file is executable (in this case, there's only one).
    return [
        DefaultInfo(
            files = depset([executable]),
            executable = executable,
        )
    ]

go_binary = rule(
    implementation = _go_binary_impl,
    attrs = {
      "srcs": attr.label_list(
        allow_files = [".go"],
        doc = "Source files to compile for the main packages of this binary",
      ),
    },
    doc = "Build an executable program from Go source code",
    executable = True,
)
