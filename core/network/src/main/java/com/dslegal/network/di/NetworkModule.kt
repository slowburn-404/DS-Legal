package com.dslegal.network.di

import com.dslegal.network.services.auth.UserApiService
import com.dslegal.network.services.auth.UserApiServiceImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient(OkHttp) {
            engine {
                config {
                    val loggingInterceptor = HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                    addInterceptor(loggingInterceptor)
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }

            defaultRequest {
                headers {
                    append(HttpHeaders.Accept, "application/json")
                }
                contentType(ContentType.Application.Json)
            }

        }
    }

    single<UserApiService> {
        UserApiServiceImpl(
            ktorClient = get(),
        )
    }
}