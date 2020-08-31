package com.pa.di.modules

import com.app.bhaskar.easypaisa.repositories.EasyPaisaRepository
import com.app.bhaskar.easypaisa.repositories.RepositoryImpl
import com.app.bhaskar.easypaisa.restapi.RestApi
import com.app.dhruv.kotlinmvp.AppDatabase
import com.pa.models.dao.ResultDataDao
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class PostRepoModule {

    @Provides
    @Singleton
    fun providePostRepository(
        localSource: AppDatabase,
        remoteSource: RestApi
    ): EasyPaisaRepository= RepositoryImpl(localSource, remoteSource)
}