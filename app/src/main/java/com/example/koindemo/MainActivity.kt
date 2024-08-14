package com.example.koindemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.koindemo.ui.theme.KoinDemoTheme
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityRetainedScope
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class MainActivity : ComponentActivity(), AndroidScopeComponent {

    companion object {
        private val TAG = MainActivity::class.simpleName
    }

    // Init viewmodel Option 1 - koin way to init viewmodel
    private val viewModel by viewModel<MainViewModel>() // lazy init

    // injecting string tied to MainActivity scope
    /**
     * by using activityScope, all objects defined in MainActivity scope will not survive config change,
     * Use activityRetainedScope instead if we want them to survive config change
     * */
    //override val scope: Scope by activityScope()
    override val scope: Scope by activityRetainedScope()
    private val hello by inject<String>()
    private val myInt by inject<Int>(named("int2"))

    /*
    private val api1 = get<MyApi>() // immediate injection with class creation
    private val api2 by inject<MyApi>() // lazy init
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, hello)
        Log.d(TAG, "$myInt")
        setContent {
            KoinDemoTheme {
                // Init viewmodel Option 2 - only for compose projects
                // val vm = getViewModel<MainViewModel>()
                viewModel.doNetworkCall()
                // Log.d(TAG, hello)
            }
        }
    }
}