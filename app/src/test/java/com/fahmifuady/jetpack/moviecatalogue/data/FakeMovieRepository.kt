package com.fahmifuady.jetpack.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.LocalDataSource
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.ApiResponse
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.RemoteDataSource
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.MovieResponse
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.TvResponse
import com.fahmifuady.jetpack.moviecatalogue.utils.AppExecutors
import com.fahmifuady.jetpack.moviecatalogue.vo.Resource

class FakeMovieRepository constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors)
    : MovieDataSource {

    override fun getAllMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(14)
                    .setPageSize(14)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }


            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (i in data) {
                    val movie = MovieEntity(
                            i.id,
                            i.title,
                            i.year,
                            i.duration,
                            i.score,
                            i.genre,
                            i.imageUrl,
                            i.overview
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTv(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<TvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(14)
                    .setPageSize(14)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            public override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                    remoteDataSource.getAllTv()

            override fun saveCallResult(data: List<TvResponse>) {
                val tvList = ArrayList<MovieEntity>()
                for (i in data) {
                    val tv = MovieEntity(
                            i.id,
                            i.title,
                            i.year,
                            i.duration,
                            i.score,
                            i.genre,
                            i.imageUrl,
                            i.overview
                    )
                    tvList.add(tv)
                }

                localDataSource.insertMovie(tvList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(id: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                    localDataSource.getDetail(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                    data == null || data.id.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                //movie.add(data)
                for (i in data) {
                    val movie = MovieEntity(i.id,
                            i.title,
                            i.year,
                            i.duration,
                            i.score,
                            i.genre,
                            i.imageUrl,
                            i.overview
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovie(movieList)
            }

        }.asLiveData()
    }

    override fun getDetailTv(id: String): LiveData<Resource<MovieEntity>> {
      return object : NetworkBoundResource<MovieEntity, List<TvResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                    localDataSource.getDetail(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                    data == null || data.id.isEmpty()


            override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                    remoteDataSource.getAllTv()

            override fun saveCallResult(data: List<TvResponse>) {
                val tvList = ArrayList<MovieEntity>()
                //tv.add(data)
                for (i in data) {
                    val tv = MovieEntity(i.id,
                            i.title,
                            i.year,
                            i.duration,
                            i.score,
                            i.genre,
                            i.imageUrl,
                            i.overview,
                            //i.favorite
                    )
                    tvList.add(tv)
                }

                localDataSource.insertMovie(tvList)
            }

        }.asLiveData()
    }

    override fun getFavoritesMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(14)
            .setPageSize(14)
            .build()
        return LivePagedListBuilder(localDataSource.getAllMovieFavorite(), config).build()
    }

    override fun getFavoriteTv(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(14)
            .setPageSize(14)
            .build()
        return LivePagedListBuilder(localDataSource.getAllTvFavorite(), config).build()
    }

    override fun setFavorites(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavorite(movie, state) }
    }
}