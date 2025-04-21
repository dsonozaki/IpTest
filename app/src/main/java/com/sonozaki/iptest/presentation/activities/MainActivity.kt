package com.sonozaki.iptest.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sonozaki.iptest.presentation.components.DisplayIp
import com.sonozaki.iptest.presentation.viewmodels.IpViewModel
import com.sonozaki.iptest.ui.theme.IpTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val ipViewmodel by viewModels<IpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IpTestTheme {
                val ipState = ipViewmodel.ipFlow.collectAsStateWithLifecycle()
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    DisplayIp(Modifier.Companion.padding(innerPadding), ipState) {
                        ipViewmodel.refreshIpResult()
                    }
                }
            }
        }
    }
}