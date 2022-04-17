package com.fahmifuady.jetpack.moviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.MovieResponse
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.TvResponse
import com.fahmifuady.jetpack.moviecatalogue.utils.EspressoIdlingResource
import com.fahmifuady.jetpack.moviecatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper)
                }
    }

    fun getAllMovie(): LiveData<ApiResponse<List<MovieResponse>>>{
        EspressoIdlingResource.increment()
        val resultMv = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        resultMv.value = ApiResponse.success(jsonHelper.loadMovie())
        EspressoIdlingResource.decrement()
        return resultMv
    }

    fun getAllTv(): LiveData<ApiResponse<List<TvResponse>>>{
        EspressoIdlingResource.increment()
        val resultTv = MutableLiveData<ApiResponse<List<TvResponse>>>()
        resultTv.value = ApiResponse.success(jsonHelper.loadTv())
        EspressoIdlingResource.decrement()
        return resultTv
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadTvCallback {
        fun onAllTvReceived(tvResponse: List<TvResponse>)
    }
}