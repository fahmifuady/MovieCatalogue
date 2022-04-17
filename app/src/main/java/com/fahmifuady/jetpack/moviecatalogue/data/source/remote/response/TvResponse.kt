package com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse(
        val id: String,
        var title: String,
        var year: String,
        var duration: String,
        var score: String,
        var genre: String,
        var imageUrl: String,
        var overview: String,
        //var favorite: String
): Parcelable
