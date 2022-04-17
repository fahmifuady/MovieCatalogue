package com.fahmifuady.jetpack.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.room.MovieDAO

class LocalDataSource private constructor(private val mMovieDAO: MovieDAO){

    companion object {
        private val instance: LocalDataSource? = null

        fun getInstance(movieDAO: MovieDAO): LocalDataSource =
            instance ?: LocalDataSource(movieDAO)
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mMovieDAO.getMovie()

    fun getAllTv(): DataSource.Factory<Int, MovieEntity> = mMovieDAO.getTv()

    fun getDetail(id: String): LiveData<MovieEntity> = mMovieDAO.getDetailById(id)

    fun getAllMovieFavorite(): DataSource.Factory<Int, MovieEntity> = mMovieDAO.getMovieFavorite()

    fun getAllTvFavorite(): DataSource.Factory<Int, MovieEntity> = mMovieDAO.getTvFavorite()

    fun insertMovie(movieEntity: List<MovieEntity>) = mMovieDAO.insertMovie(movieEntity)

    fun setFavorite(movieEntity: MovieEntity, newState: Boolean) {
        movieEntity.favorite = newState
        mMovieDAO.updateMovie(movieEntity)
    }
}