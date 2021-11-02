package com.github.irvifa.helloworld

import io.dropwizard.Configuration

class HelloWorldConfiguration : Configuration() {
    val template: String? = ""

    val defaultName: String? = "Stranger"
}
