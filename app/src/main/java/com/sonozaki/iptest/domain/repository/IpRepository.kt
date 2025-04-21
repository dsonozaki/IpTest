package com.sonozaki.iptest.domain.repository

import com.sonozaki.iptest.domain.entitities.RequestResult
import kotlinx.coroutines.flow.Flow

interface IpRepository {
    val ipFlow: Flow<RequestResult<String>>
    suspend fun reloadIp()
}