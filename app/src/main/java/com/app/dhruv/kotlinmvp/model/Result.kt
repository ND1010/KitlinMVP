package com.pa.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "easypaisa_itunes")
data class Result(
        @ColumnInfo(name = "id")@PrimaryKey(autoGenerate = true)var id : Int=0,
        val artistId: Int = 0,
        val artistName: String = "",
        val artistViewUrl: String = "",
        val artworkUrl100: String = "",
        val artworkUrl30: String = "",
        val artworkUrl60: String = "",
        val collectionArtistId: Int = 0,
        val collectionArtistName: String = "",
        val collectionArtistViewUrl: String = "",
        val collectionCensoredName: String = "",
        val collectionExplicitness: String = "",
        val collectionHdPrice: Double = 0.0,
        val collectionId: Int = 0,
        val collectionName: String = "",
        val collectionPrice: Double = 0.0,
        val collectionViewUrl: String = "",
        val contentAdvisoryRating: String = "",
        val country: String = "",
        val currency: String = "",
        val discCount: Int = 0,
        val discNumber: Int = 0,
        val isStreamable: Boolean = false,
        val kind: String = "",
        val longDescription: String = "",
        val previewUrl: String = "",
        val primaryGenreName: String = "",
        val releaseDate: String = "",
        val shortDescription: String = "",
        val trackCensoredName: String = "",
        val trackCount: Int = 0,
        val trackExplicitness: String = "",
        val trackHdPrice: Double = 0.0,
        val trackHdRentalPrice: Double = 0.0,
        val trackId: Int = 0,
        val trackName: String = "",
        val trackNumber: Int = 0,
        val trackPrice: Double = 0.0,
        val trackRentalPrice: Double = 0.0,
        val trackTimeMillis: Int = 0,
        val trackViewUrl: String = "",
        val wrapperType: String = ""
)