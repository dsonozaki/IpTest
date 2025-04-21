package com.sonozaki.iptest.domain.usecase

import com.sonozaki.iptest.domain.repository.IpRepository
import javax.inject.Inject

class RefreshIpResultUseCase @Inject constructor(val ipRepository: IpRepository) {
    suspend operator fun invoke() {
        ipRepository.reloadIp()
    }
}