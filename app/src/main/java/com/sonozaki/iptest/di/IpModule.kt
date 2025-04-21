package com.sonozaki.iptest.di

import com.sonozaki.iptest.data.mappers.IpDTOToStringMapper
import com.sonozaki.iptest.data.network.IpDTO
import com.sonozaki.iptest.data.network.IpService
import com.sonozaki.iptest.domain.Mapper
import com.sonozaki.iptest.domain.entitities.RequestResult
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableSharedFlow
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class IpModule {

    @Provides
    @Singleton
    fun provideIpFlow(): MutableSharedFlow<RequestResult<String>> = MutableSharedFlow()

    @Provides
    @Singleton
    fun provideIpDTOToStringMapper(): Mapper<IpDTO, String> = IpDTOToStringMapper()

    @Provides
    @Singleton
    fun provideIpService(retrofit: Retrofit): IpService = retrofit.create(IpService::class.java)
}