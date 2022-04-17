package com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "year")
        var year: String,

        @ColumnInfo(name = "duration")
        var duration: String,

        @ColumnInfo(name = "score")
        var score: String,

        @ColumnInfo(name = "genre")
        var genre: String,

        @ColumnInfo(name = "imageUrl")
        var imageUrl: String,

        @ColumnInfo(name = "overview")
        var overview: String,

        //lupa blm bikin di awal
        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false
)