package com.app.dhruv.kotlinmvp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TV_SHOWS")
data class TvShowsEntity
    (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "show_id") var show_id: Int = 0,
     @ColumnInfo(name = "watched_episode_ids") var watched_episode_ids: String = "",
     @ColumnInfo(name = "watched_season_ids") var watched_season_ids: String = "",
     @ColumnInfo(name = "favrate") var favrate: Boolean = false,
     @ColumnInfo(name = "show_name") var show_name: String){
    constructor() : this(0,"","",false,"")
}