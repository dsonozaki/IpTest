package com.sonozaki.iptest.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sonozaki.iptest.R
import com.sonozaki.iptest.presentation.states.IpState

@Composable
fun DisplayIp(modifier: Modifier = Modifier, ipState: State<IpState>, reloadIp: () -> Unit) {
    val context = LocalContext.current
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (val state = ipState.value) {
            is IpState.Data -> {
                Text(text = state.ip)
            }

            is IpState.Error -> {
                Column(modifier = Modifier.padding(16.dp, 0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = state.errorDescription.asString(context),
                        maxLines = 3,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis
                    )
                    Button(onClick = reloadIp) {
                        Text(text = stringResource(R.string.reload))
                    }
                }
            }

            is IpState.Loading -> {
                Box {
                    CircularProgressIndicator()
                }
            }
        }
    }
}
