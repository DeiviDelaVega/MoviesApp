package com.dev.moviesapp.data.di

import com.dev.moviesapp.data.interceptor.AuthInterceptor
import com.dev.moviesapp.data.remote.api.MovieService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Módulo de red encargado de configurar y proveer las dependencias
 * necesarias para consumir la API REST de TMDB mediante Retrofit.
 *
 * Las dependencias se construyen en el siguiente orden:
 *
 *   BASE_URL → Gson → AuthInterceptor → OkHttpClient → Retrofit
 *
 * Cada dependencia cumple un rol específico:
 *  - BASE_URL:         Define el endpoint raíz de la API de TMDB.
 *  - Gson:             Deserializa las respuestas JSON en modelos de datos Kotlin.
 *  - AuthInterceptor:  Intercepta cada petición HTTP e inyecta el token de autenticación.
 *  - OkHttpClient:     Gestiona las conexiones HTTP con el interceptor configurado.
 *  - Retrofit:         Orquesta todas las dependencias anteriores para exponer los servicios de la API.
 *
 * Al estar instalado en [SingletonComponent], todas las instancias
 * marcadas con @Singleton se crean una sola vez y persisten
 * durante todo el ciclo de vida de la aplicación.
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String {
        return Constant.BASE_URL
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                provideAuthInterceptor()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor(Constant.ACCESS_TOKEN)
    }

    @Provides
    @Singleton
    fun providerRetrofit(
        baseUrl: String,
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit) : MovieService {
        return retrofit.create(MovieService::class.java)

    }
}