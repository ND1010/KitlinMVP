package com.pa.di.modules

import androidx.room.Room
import android.content.Context
import com.app.dhruv.kotlinmvp.AppDatabase
import com.pa.models.dao.ResultDataDao

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val context: Context) {

    val DB_FILE_NAME = "myapp.db"

    @Provides @Singleton
    fun provideContactDao(appDatabase: AppDatabase) : ResultDataDao = appDatabase.metOfficeDataDao()

    @Provides @Singleton
    fun privideAppDatabase() : AppDatabase =

            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_FILE_NAME)
                    .build()



}