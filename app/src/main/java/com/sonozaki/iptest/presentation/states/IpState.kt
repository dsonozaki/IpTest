package com.sonozaki.iptest.presentation.states

import com.sonozaki.iptest.core.ui.UIText

/**
 * Representation of IP screen state
 */
sealed class IpState {
    data object Loading: IpState()
    data class Data(val ip: String): IpState()
    data class Error(val errorDescription: UIText): IpState()
}