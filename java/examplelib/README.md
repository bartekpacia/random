### run junit tests without any build system

```shell
$ java \
  -cp out/test/classes:/Users/Bartek.Pacia/.cache/gradle/caches/modules-2/files-2.1/junit/junit/4.13.1/cdd00374f1fee76b11e2a9d127405aa3f6be5b6a/junit-4.13.1.jar:/Users/Bartek.Pacia/.cache/gradle/caches/modules-2/files-2.1/org.hamcrest/hamcrest-core/1.3/42a25dc3219429f0e5d060061f71acb49bf010a0/hamcrest-core-1.3.jar \
  org.junit.runner.JUnitCore \
  SomeTests
```