package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.media.Schema

fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("com.example")
        .start()
}

@Controller("/v1/things")
class ThingsController {
    @Get
    suspend fun getThing(): Thing {
        return Thing("super thing")
    }
}

@Schema(name = "Thing")
data class Thing(
    val thingName: String
)