package com.sonozaki.iptest.domain.repository

import com.sonozaki.iptest.domain.entitities.RequestResult
import kotlinx.coroutines.flow.Flow

/**
 * Repository for retrieving information about user's IP
 */
interface IpRepository {

    /**
     * Flow of IPs or errors during getting IP
     */
    val ipFlow: Flow<RequestResult<String>>

    /**
     * Get IP again
     */
    suspend fun reloadIp()
}