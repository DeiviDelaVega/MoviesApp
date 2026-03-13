package com.dev.moviesapp.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
/**
 * Interceptor HTTP que inyecta el token de autenticación
 * en cada petición saliente hacia la API de TMDB.
 */
class AuthInterceptor(private val authToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()

        val requestBuilder = originRequest.newBuilder()
            .addHeader("accept", "application/json")
            .addHeader("Authorization", "Bearer $authToken")

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}