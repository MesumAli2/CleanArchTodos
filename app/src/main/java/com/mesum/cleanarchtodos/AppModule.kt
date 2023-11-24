package com.mesum.cleanarchtodos

import com.mesum.cleanarchtodos.model.Todo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): JsonPlaceholderService{
        return retrofit.create(JsonPlaceholderService::class.java)
    }

    @Provides
    @Singleton
    fun provideTodoRepository(service: JsonPlaceholderService): TodoRepository{
        return TodoRepository(service)
    }

    @Provides
    fun provideFetchTodoUseCase(repository: TodoRepository): FetchTodoUseCase{
        return FetchTodoUseCase(repository)
    }


}
