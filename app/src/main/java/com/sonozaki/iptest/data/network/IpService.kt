package com.sonozaki.iptest.data.network

import retrofit2.http.GET


interface IpService {

    @GET(GET_IP_URL)
    suspend fun getIp(): IpDTO

    companion object {
        private const val GET_IP_URL = "/d4e2bt6jba6cmiekqmsv"
    }
}