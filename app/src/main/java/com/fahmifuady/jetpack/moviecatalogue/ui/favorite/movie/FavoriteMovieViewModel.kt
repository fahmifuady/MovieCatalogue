package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoritesMovie()

    fun setMovieFavorites(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorite
        movieRepository.setFavorites(movieEntity, newState)
    }
}