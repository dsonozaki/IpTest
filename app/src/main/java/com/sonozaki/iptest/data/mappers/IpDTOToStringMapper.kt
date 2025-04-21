package com.sonozaki.iptest.data.mappers

import com.sonozaki.iptest.data.network.IpDTO
import com.sonozaki.iptest.domain.Mapper
import javax.inject.Inject

class IpDTOToStringMapper @Inject constructor(): Mapper<IpDTO, String> {
    override fun map(from: IpDTO): String = from.myIp
}