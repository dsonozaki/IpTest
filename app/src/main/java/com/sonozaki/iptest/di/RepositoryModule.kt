package com.sonozaki.iptest.di

import com.sonozaki.iptest.data.repository.IpRepositoryImpl
import com.sonozaki.iptest.domain.repository.IpRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIpRepository(ipRepositoryImpl: IpRepositoryImpl): IpRepository
}