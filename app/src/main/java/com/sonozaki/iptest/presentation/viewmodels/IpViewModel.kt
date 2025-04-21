package com.sonozaki.iptest.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonozaki.iptest.core.SHARING_STARTED_TIMEOUT
import com.sonozaki.iptest.domain.entitities.RequestResult
import com.sonozaki.iptest.domain.usecase.GetIpResultUseCase
import com.sonozaki.iptest.domain.usecase.RefreshIpResultUseCase
import com.sonozaki.iptest.presentation.states.IpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IpViewModel @Inject constructor(
    getIpResultUseCase: GetIpResultUseCase,
    private val refreshIpResultUseCase: RefreshIpResultUseCase
): ViewModel() {

    //load IP when ViewModel is created
    init {
        refreshIpResult()
    }

    val ipFlow = getIpResultUseCase().map {
        when(it) {
            is RequestResult.Data -> IpState.Data(it.data)
            is RequestResult.Error -> IpState.Error(it.errorDescription)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(SHARING_STARTED_TIMEOUT),
        initialValue = IpState.Loading
    )

    fun refreshIpResult() {
        viewModelScope.launch {
            refreshIpResultUseCase()
        }
    }
}