package com.github.networkguild

import com.github.networkguild.rest.ProxmoxController
import io.micronaut.configuration.picocli.PicocliRunner
import jakarta.inject.Inject
import org.slf4j.LoggerFactory
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(name = "proxmox-api", description = ["..."],
        mixinStandardHelpOptions = true)
class ProxmoxApiCommand : Runnable {

    @Inject
    lateinit var proxmoxController: ProxmoxController

    @Option(names = ["-v", "--verbose"], description = ["Verbose logging"])
    private var verbose : Boolean = false

    @Option(names = ["-g", "--get"], description = ["Get token from the cluster, specify ip e.g. -g 192.168.1.10"])
    private lateinit var get : String

    override fun run() {
        val logger = if (verbose) LoggerFactory.getLogger(javaClass) else null

        if (get.isNotEmpty()) {
            logger?.info("Getting token from cluster!")
            proxmoxController.getTokenData(get)
        }

    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(ProxmoxApiCommand::class.java, *args)
        }
    }
}
