package com.app.dhruv.kotlinmvp.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.dhruv.kotlinmvp.model.TvShowsEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ShowBasicInfoDao {

    @Query("Select * from TV_SHOWS")
    fun getAllShows(): Single<List<TvShowsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShow(series: TvShowsEntity) : Completable
    
}
