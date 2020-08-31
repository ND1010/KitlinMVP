package com.app.dhruv.kotlinmvp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.dhruv.kotlinmvp.model.TvShowsEntity
import com.app.dhruv.kotlinmvp.model.dao.ShowBasicInfoDao
import com.pa.models.Result

import com.pa.models.dao.ResultDataDao

@Database(entities = [Result::class, TvShowsEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun metOfficeDataDao(): ResultDataDao
    abstract fun metTVShowDao(): ShowBasicInfoDao
}