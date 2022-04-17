package com.fahmifuady.jetpack.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.dl.Injection
import com.fahmifuady.jetpack.moviecatalogue.ui.detail.DetailViewModel
import com.fahmifuady.jetpack.moviecatalogue.ui.favorite.movie.FavoriteMovieViewModel
import com.fahmifuady.jetpack.moviecatalogue.ui.favorite.tv.FavoriteTvViewModel
import com.fahmifuady.jetpack.moviecatalogue.ui.movie.MovieViewModel
import com.fahmifuady.jetpack.moviecatalogue.ui.tv.TvViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepository) as T
            }

            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                return TvViewModel(mMovieRepository) as T
            }

            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mMovieRepository) as T
            }

            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                return FavoriteMovieViewModel(mMovieRepository) as T
            }

            modelClass.isAssignableFrom(FavoriteTvViewModel::class.java) -> {
                return FavoriteTvViewModel(mMovieRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class" + modelClass.name)

        }
    }
}