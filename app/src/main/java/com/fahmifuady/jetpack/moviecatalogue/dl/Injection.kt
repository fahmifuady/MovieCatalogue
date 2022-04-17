package com.fahmifuady.jetpack.moviecatalogue.dl

import android.content.Context
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.LocalDataSource
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.room.MovieDatabase
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.RemoteDataSource
import com.fahmifuady.jetpack.moviecatalogue.utils.AppExecutors
import com.fahmifuady.jetpack.moviecatalogue.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): MovieRepository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDAO())
        val appExecutors = AppExecutors()
        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}