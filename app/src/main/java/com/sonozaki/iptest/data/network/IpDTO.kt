package com.sonozaki.iptest.data.network

import com.google.gson.annotations.SerializedName

data class IpDTO(
    @SerializedName("myip")
    val myIp: String
)