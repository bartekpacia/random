# How does Compose DSL work?

The thing that I don't understand:

This works:

```kotlin
@Composable
fun Screen() {
    Column {
        Text(
            text = "Hello",
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}
```

but this doesn't:

```kotlin
@Composable
fun Screen() {
    Text(
        text = "Hello",
        modifier = Modifier.align(Alignment.CenterHorizontally),
    )
}
```

```
[UNRESOLVED_REFERENCE] Unresolved reference 'align'.
```

## Answer

Extension function defined in a specific scope.

There's globally-accessible `Modifier` class:

```kotlin
class Modifier {
    fun align()
}
```

and then `RowScope` (which is a receiver in `Row.content` closure – type of this closure is `RowScope.() -> ()`):

```kotlin
interface RowScope() {
    fun Modifier.align(align: Alignment.Vertical)
}
```
