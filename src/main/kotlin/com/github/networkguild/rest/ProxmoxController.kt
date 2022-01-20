package com.github.networkguild.rest

import com.github.networkguild.domain.Token
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import reactor.core.publisher.Mono

@Controller
class ProxmoxController {

    @Inject
    lateinit var proxmoxClient: ProxmoxClient

    @Get
    fun getTokenData(ip: String): Mono<Token> =
        proxmoxClient.getAToken(ip)
}