package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity

class FavoriteTvViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getFavoriteTv(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteTv()

    fun setTvFavorites(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        movieRepository.setFavorites(movieEntity, newState)
    }
}