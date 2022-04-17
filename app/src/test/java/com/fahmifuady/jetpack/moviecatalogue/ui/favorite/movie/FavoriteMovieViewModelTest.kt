package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {

    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMovieViewModel(movieRepository)
    }

    @Test
    fun getFavorite() {
        val dummy = pagedList
        `when`(dummy.size).thenReturn(14)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummy

        `when`(movieRepository.getFavoritesMovie()).thenReturn(movie)
        val movieEntity = viewModel.getFavoriteMovie().value
        verify(movieRepository).getFavoritesMovie()
        assertNotNull(movieEntity)
        assertEquals(14, movieEntity?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        verify(observer).onChanged(dummy)
    }


}