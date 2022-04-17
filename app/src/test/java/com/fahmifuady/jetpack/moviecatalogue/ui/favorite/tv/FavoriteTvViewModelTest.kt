package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fahmifuady.jetpack.moviecatalogue.data.MovieRepository
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
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
class FavoriteTvViewModelTest {

    private lateinit var viewModel: FavoriteTvViewModel

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
        viewModel = FavoriteTvViewModel(movieRepository)
    }

    @Test
    fun getFavorite(){
        val dummy = pagedList
        `when`(dummy.size).thenReturn(14)
        val tv = MutableLiveData<PagedList<MovieEntity>>()
        tv.value = dummy

        `when`(movieRepository.getFavoriteTv()).thenReturn(tv)
        val tvEntity = viewModel.getFavoriteTv().value
        verify(movieRepository).getFavoriteTv()
        assertNotNull(tvEntity)
        assertEquals(14, tvEntity?.size)

        viewModel.getFavoriteTv().observeForever(observer)
        verify(observer).onChanged(dummy)
    }
}