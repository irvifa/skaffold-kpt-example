package com.github.irvifa.helloworld

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

class HelloWorldConfiguration : Configuration() {
    val template: String? = ""

    val defaultName: String? = "Stranger"
}
