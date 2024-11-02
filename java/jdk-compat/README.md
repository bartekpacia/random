Testing how JDK behaves when loading class file that contains references to
methods not present in it.

For example: trying to run program that uses JDK11 classes on JDK8.

### On JDK11

```console
javac -target 8 -source 8 Main.java
```

### On JDK8

```console
java Main
```

# Verdict

NoSuchMethodError is thrown only when JVM tries to call the method. It does not
occur when the class is first loaded.
