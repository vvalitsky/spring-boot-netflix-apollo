package com.vvalitsky

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Main application entrypoint.
 *
 * @author Vladislav Valitsky
 */
@SpringBootApplication
class EmployeeApplication

fun main(args: Array<String>) {
    SpringApplication.run(EmployeeApplication::class.java, *args)
}
