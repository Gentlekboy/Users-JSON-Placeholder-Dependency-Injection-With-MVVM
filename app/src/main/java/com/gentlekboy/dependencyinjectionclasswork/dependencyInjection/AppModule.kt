package com.gentlekboy.dependencyinjectionclasswork.dependencyInjection

import com.gentlekboy.dependencyinjectionclasswork.networkClient.GetUsersInterface
import com.gentlekboy.dependencyinjectionclasswork.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//App Module contains all our dependencies
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //Create a single instance of retrofit
    @Singleton
    @Provides
    fun getRetroInstance(): Retrofit{
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Create a single instance of retrofit connected to the interface with the endpoint
    @Singleton
    @Provides
    fun connectRetrofitToInterface (retrofit: Retrofit): GetUsersInterface{
        return retrofit.create(GetUsersInterface::class.java)
    }
}