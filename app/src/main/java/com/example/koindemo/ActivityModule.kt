package com.example.koindemo

import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 *  These dependencies will only live as far as activity is alive
 * */
val activityModule = module {
    // these dependencies are scoped to MainActivity
    scope<MainActivity> {
        scoped { "Hello" } // when MainActivity is destroyed, this string dependency will also destroy

        scoped(qualifier = named("int1")) { 25 }
        scoped(qualifier = named("int2")) { 52 } // qualifier used to identify between multiple obj of same type
    }
}