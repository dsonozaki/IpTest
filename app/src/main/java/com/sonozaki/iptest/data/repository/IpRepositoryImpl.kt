package com.sonozaki.iptest.data.repository

import com.sonozaki.iptest.core.network.safeApiCallWithMapper
import com.sonozaki.iptest.data.network.IpDTO
import com.sonozaki.iptest.data.network.IpService
import com.sonozaki.iptest.domain.Mapper
import com.sonozaki.iptest.domain.entitities.RequestResult
import com.sonozaki.iptest.domain.repository.IpRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class IpRepositoryImpl @Inject constructor(
    private val ipService: IpService,
    private val _ipFlow: MutableSharedFlow<RequestResult<String>>,
    private val ipDTOToStringMapper: Mapper<IpDTO, String>
) : IpRepository {

    override val ipFlow: Flow<RequestResult<String>>
        get() = _ipFlow.asSharedFlow()

    override suspend fun reloadIp() {
        val ipResult = safeApiCallWithMapper(ipDTOToStringMapper) {
            ipService.getIp()
        }
        _ipFlow.emit(ipResult)
    }
}