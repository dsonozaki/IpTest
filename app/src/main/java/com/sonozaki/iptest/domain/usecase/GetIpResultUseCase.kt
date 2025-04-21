package com.sonozaki.iptest.domain.usecase

import com.sonozaki.iptest.domain.entitities.RequestResult
import com.sonozaki.iptest.domain.repository.IpRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetIpResultUseCase @Inject constructor(val ipRepository: IpRepository) {
    operator fun invoke(): Flow<RequestResult<String>> = ipRepository.ipFlow
}