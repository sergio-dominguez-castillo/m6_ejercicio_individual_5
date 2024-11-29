package cl.bootcamp.ejercicioindividual5.di

import cl.bootcamp.ejercicioindividual5.data.ApiArticles
import cl.bootcamp.ejercicioindividual5.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiArticles(retrofit: Retrofit): ApiArticles {
        return retrofit.create(ApiArticles::class.java)
    }
}