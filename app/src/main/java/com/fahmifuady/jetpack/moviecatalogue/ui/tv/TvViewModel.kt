package com.fahmifuady.jetpack.moviecatalogue.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.vo.Resource

class TvViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getTv(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllTv()
}