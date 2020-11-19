package hr.onit.agency

import hr.onit.agency.service_calls.UserNamePasswordAuthenticator
import org.openapitools.client.infrastructure.ApiClient

fun main(args: Array<String>) {
    ApiClient.builder.authenticator(UserNamePasswordAuthenticator())
    Agency().main(args)
}