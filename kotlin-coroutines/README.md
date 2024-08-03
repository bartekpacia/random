# how to run it

### compile

```console
kotlinc \
	main.kt \
  -cp ~/.cache/gradle/caches/modules-2/files-2.1/org.jetbrains.kotlinx/kotlinx-coroutines-core-jvm/1.8.0/ac1dc37a30a93150b704022f8d895ee1bd3a36b3/kotlinx-coroutines-core-jvm-1.8.0.jar \
  -include-runtime \
  -d main.jar
```

### run

```console
java \
  -cp main.jar:~/.cache/gradle/caches/modules-2/files-2.1/org.jetbrains.kotlinx/kotlinx-coroutines-core-jvm/1.8.0/ac1dc37a30a93150b704022f8d895ee1bd3a36b3/kotlinx-coroutines-core-jvm-1.8.0.jar \
  MainKt
```

