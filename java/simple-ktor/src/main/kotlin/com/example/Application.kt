package com.example

import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain

class Wrapper {
    class Application {
        companion object {
            @JvmStatic
            fun main(args: Array<String>) {
                EngineMain.main(args)
            }
        }
    }
}

fun Application.module() {
    configureRouting()
}
