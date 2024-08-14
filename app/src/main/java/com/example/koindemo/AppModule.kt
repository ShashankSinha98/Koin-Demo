package com.example.koindemo

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    /**
     * Creates singleton instance of MyApi class - it's implementation is provided by Retrofit
     * Wherever, there is dependency of MyApi in any class's constructor, this will execute and create
     * a singleton instance only once and pass it.
     *
     * factory {} scope - create new instance everytime
     * */
    single {
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

    single<MainRepository> {  // We're passing abstraction, like MainRepository repo = new MainRepositoryImpl(...);
        // wherever, there is dependency of MainRepositoryImpl, it will execute
        // get() is used to get dependency which is already defined in koin
        MainRepositoryImpl(
            api = get()
        )
    }

    // for creating view models
    viewModel {
        MainViewModel(
            repository = get()
        )
    }
}