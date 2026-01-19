package tech.pacia.context_parameters

fun main() {
    val foo = Foo(
        name = "foo1",
        callback = {
            someOtherFunctionThatNeeds(contextOf<Server>())
        }
    )
}

class Foo(
    private val name: String,
    private val callback: context(Server) () -> Unit,
)

class Server

fun someOtherFunctionThatNeeds(server: Server) {
    println("I am doing something important with server $server")
}