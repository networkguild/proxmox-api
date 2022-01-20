package com.github.networkguild;


import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ProxmoxApiCommandTest {

    @Test
    fun testWithCommandLineOption() {
        val ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
        val byteArray = ByteArrayOutputStream()
        System.setOut(PrintStream(byteArray))

        val args = arrayOf("-v")
        PicocliRunner.run(ProxmoxApiCommand::class.java, ctx, *args)

        assertTrue(byteArray.toString().contains("Hi!"))

        ctx.close()
    }
}
