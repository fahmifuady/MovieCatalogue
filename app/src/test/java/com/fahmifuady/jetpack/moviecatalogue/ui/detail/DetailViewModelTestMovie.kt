package com.fahmifuady.jetpack.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.utils.DummyData
import com.fahmifuady.jetpack.moviecatalogue.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTestMovie {

    private lateinit var viewModel: DetailViewModel
    private val dummy = DummyData.generateMovies()[0]
    private val mId = dummy.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setup() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedItem(mId)
    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = Resource.success(dummy)
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieRepository.getDetailMovie(mId)).thenReturn(movie)
        val movieEntities = viewModel.getAllMovie().value?.data as MovieEntity
        viewModel.setSelectedItem(dummy.id)
        verify(movieRepository).getDetailMovie(mId)
        assertNotNull(movieEntities)

        assertEquals(dummy.id, movieEntities.id)
        assertEquals(dummy.title, movieEntities.title)
        assertEquals(dummy.year, movieEntities.year)
        assertEquals(dummy.duration, movieEntities.duration)
        assertEquals(dummy.score, movieEntities.score)
        assertEquals(dummy.genre, movieEntities.genre)
        assertEquals(dummy.imageUrl, movieEntities.imageUrl)
        assertEquals(dummy.overview, movieEntities.overview)

        viewModel.getAllMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}