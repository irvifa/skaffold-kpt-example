package com.github.irvifa.helloworld

import com.github.irvifa.helloworld.health.HelloWorldHealthCheck
import com.github.irvifa.helloworld.resources.HelloWorldResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import org.slf4j.LoggerFactory

class HelloWorldApplication : Application<HelloWorldConfiguration>() {
    override fun getName(): String {
        return "hello-world"
    }

    override fun initialize(bootstrap: Bootstrap<HelloWorldConfiguration>) {
        // nothing to do yet
    }

    @Throws(Exception::class)
    override fun run(
        configuration: HelloWorldConfiguration,
        environment: Environment
    ) {
        val resource = HelloWorldResource(
            configuration.template!!,
            configuration.defaultName!!
        )
        val healthCheck = HelloWorldHealthCheck(configuration.template)
        environment.healthChecks().register("template", healthCheck)
        environment.jersey().register(resource)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(HelloWorldApplication::class.java)

        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            HelloWorldApplication().run(*args)
        }
    }
}
