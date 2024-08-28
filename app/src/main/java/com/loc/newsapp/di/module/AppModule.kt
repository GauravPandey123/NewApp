package com.loc.newsapp.di.module

import android.app.Application
import com.loc.newsapp.data.manger.LocalUserManagerImpl
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.usecases.AppEntryUseCases
import com.loc.newsapp.domain.usecases.ReadAppEntry
import com.loc.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) =
        AppEntryUseCases(
            readerAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager)
        )

}