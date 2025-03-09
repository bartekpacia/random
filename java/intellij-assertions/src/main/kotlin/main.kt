import org.jetbrains.annotations.ApiStatus

@ApiStatus.NonExtendable
fun main() {
  var a: Class? = null
}


@ApiStatus.NonExtendable
open class Class {

  @ApiStatus.NonExtendable
  open fun main() {

    var x = 4


    @ApiStatus.NonExtendable fun a() {

    }
  }
}

@ApiStatus.NonExtendable
class XD {}
