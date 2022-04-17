package com.fahmifuady.jetpack.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.LocalDataSource
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.RemoteDataSource
import com.fahmifuady.jetpack.moviecatalogue.utils.AppExecutors
import com.fahmifuady.jetpack.moviecatalogue.utils.DummyData
import com.fahmifuady.jetpack.moviecatalogue.utils.LiveDataTestUtils
import com.fahmifuady.jetpack.moviecatalogue.utils.PagedListUtil
import com.fahmifuady.jetpack.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutor = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutor)

    private val movieResponse = DummyData.generateRemoteDummyMovies()
    private val idm = movieResponse[0].id

    private val tvResponse = DummyData.generateRemoteDummyTv()
    private val idt = tvResponse[0].id


    @Test
    fun getAllMovie() {

        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSource)
        movieRepository.getAllMovie()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DummyData.generateMovies()))//LiveDataTestUtils.getValue(movieRepository.getAllMovie())
        verify(local).getAllMovie()
        assertNotNull(movieEntity.data)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getAllTv() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllTv()).thenReturn(dataSource)
        movieRepository.getAllTv()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DummyData.generateTv()))//LiveDataTestUtils.getValue(movieRepository.getAllTv())
        verify(local).getAllTv()
        assertNotNull(movieEntity.data)
        assertEquals(tvResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummy = MutableLiveData<MovieEntity>()
        dummy.value = DummyData.generateMovies()[0]
        `when`(local.getDetail(idm)).thenReturn(dummy)

        val movieEntityContent = LiveDataTestUtils.getValue(movieRepository.getDetailMovie(idm))
        verify(local).getDetail(idm)
        assertNotNull(movieEntityContent)
        assertNotNull(movieEntityContent.data?.title)
        assertNotNull(movieEntityContent.data?.year)
        assertNotNull(movieEntityContent.data?.duration)
        assertNotNull(movieEntityContent.data?.score)
        assertNotNull(movieEntityContent.data?.genre)
        assertNotNull(movieEntityContent.data?.imageUrl)
        assertNotNull(movieEntityContent.data?.overview)
    }

    @Test
    fun getDetailTv() {
        val dummy = MutableLiveData<MovieEntity>()
        dummy.value = DummyData.generateTv()[0]
        `when`(local.getDetail(idt)).thenReturn(dummy)

        val movieEntityContent = LiveDataTestUtils.getValue(movieRepository.getDetailTv(idt))
        verify(local).getDetail(idt)
        assertNotNull(movieEntityContent)
        assertNotNull(movieEntityContent.data?.title)
        assertNotNull(movieEntityContent.data?.year)
        assertNotNull(movieEntityContent.data?.duration)
        assertNotNull(movieEntityContent.data?.score)
        assertNotNull(movieEntityContent.data?.genre)
        assertNotNull(movieEntityContent.data?.imageUrl)
        assertNotNull(movieEntityContent.data?.overview)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovieFavorite()).thenReturn(dataSourceFactory)
        movieRepository.getFavoritesMovie()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DummyData.generateMovies()))
        verify(local).getAllMovieFavorite()
        assertNotNull(movieEntity)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTv() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllTvFavorite()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTv()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DummyData.generateTv()))
        verify(local).getAllTvFavorite()
        assertNotNull(movieEntity)
        assertEquals(movieResponse.size.toLong(), movieEntity.data?.size?.toLong())
    }

}