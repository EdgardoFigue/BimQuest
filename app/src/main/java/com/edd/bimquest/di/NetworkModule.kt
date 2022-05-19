package com.edd.bimquest.di

import com.edd.bimquest.data.network.PostApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
   fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
   }

    @Singleton
    @Provides
    fun providePostApiClient(retrofit: Retrofit) : PostApiClient {
        return retrofit.create(PostApiClient::class.java)
    }

}