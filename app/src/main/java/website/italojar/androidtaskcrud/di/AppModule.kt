package website.italojar.androidtaskcrud.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import website.italojar.androidtaskcrud.common.Constants
import website.italojar.androidtaskcrud.data.datasource.remote.interfaces.HelloWorldApi
import website.italojar.androidtaskcrud.data.repo.UserRepoImpl
import website.italojar.androidtaskcrud.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHelloWorldApi(): HelloWorldApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HelloWorldApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: HelloWorldApi): UserRepository {
        return UserRepoImpl(api)
    }
}