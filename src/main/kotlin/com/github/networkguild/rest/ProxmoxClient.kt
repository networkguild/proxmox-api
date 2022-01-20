package com.github.networkguild.rest

import com.github.networkguild.domain.Token
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono

@Client
@Header(name = "Accept", value = "application/json")
interface ProxmoxClient {

    @Get("https://{ipAddress}:8006/api2/json/access/ticket")
    fun getAToken(@QueryValue ipAddress: String): Mono<Token>

    @Get
    fun getContainerInfo()

}
