package com.fahmifuady.jetpack.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.vo.Resource

interface MovieDataSource {

    fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllTv(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(id: String): LiveData<Resource<MovieEntity>>

    fun getDetailTv(id: String): LiveData<Resource<MovieEntity>>

    fun getFavoritesMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTv(): LiveData<PagedList<MovieEntity>>

    fun setFavorites(movie: MovieEntity, state: Boolean)
}