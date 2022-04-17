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
class DetailViewModelTestTv {

    private lateinit var viewModel: DetailViewModel
    private val dummy = DummyData.generateTv()[0]
    private val tId = dummy.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    @Before
    fun setup() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelectedItem(tId)
    }

    @Test
    fun getDetailTv() {

        val dummyTv = Resource.success(dummy)
        val tv = MutableLiveData<Resource<MovieEntity>>()
        tv.value = dummyTv

        `when`(movieRepository.getDetailTv(tId)).thenReturn(tv)
        val tvEntities = viewModel.getAllTv().value?.data as MovieEntity
        viewModel.setSelectedItem(dummy.id)
        verify(movieRepository).getDetailTv(tId)
        assertNotNull(tvEntities)

        assertEquals(dummy.id, tvEntities.id)
        assertEquals(dummy.title, tvEntities.title)
        assertEquals(dummy.year, tvEntities.year)
        assertEquals(dummy.duration, tvEntities.duration)
        assertEquals(dummy.score, tvEntities.score)
        assertEquals(dummy.genre, tvEntities.genre)
        assertEquals(dummy.imageUrl, tvEntities.imageUrl)
        assertEquals(dummy.overview, tvEntities.overview)

        viewModel.getAllTv().observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }
}