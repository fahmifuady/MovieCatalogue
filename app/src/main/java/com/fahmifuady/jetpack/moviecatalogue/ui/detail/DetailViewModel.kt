package com.fahmifuady.jetpack.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.vo.Resource


class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private lateinit var id: String
    private val id2 = MutableLiveData<String>()

    fun setSelectedItem(id: String) {
        this.id = id
        this.id2.value = id
    }

    fun getAllMovie(): LiveData<Resource<MovieEntity>> = movieRepository.getDetailMovie(id)

    fun getAllTv(): LiveData<Resource<MovieEntity>> = movieRepository.getDetailTv(id)

    var movie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(id2) { mId -> movieRepository.getDetailMovie(mId) }

    var tv: LiveData<Resource<MovieEntity>> = Transformations.switchMap(id2) { tId -> movieRepository.getDetailTv(tId) }

    fun setFavoriteMovie() {
        val mov = movie.value
        if (mov != null) {
            val mo = mov.data

            if (mo != null) {
                val newState = !mo.favorite
                movieRepository.setFavorites(mo, newState)
            }
        }
    }

    fun setFavoriteTv() {
        val tv = tv.value
        if (tv != null) {
            val t = tv.data

            if (t != null) {
                val newState = !t.favorite
                movieRepository.setFavorites(t, newState)
            }
        }
    }
}