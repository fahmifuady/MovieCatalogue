package com.fahmifuady.jetpack.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity

@Dao
interface MovieDAO {

    // get allMovie and allTv
    @Query("SELECT * FROM movieentities WHERE id LIKE '%mv%'")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>//LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities WHERE id LIKE '%tv%'")
    fun getTv(): DataSource.Factory<Int, MovieEntity>//LiveData<List<MovieEntity>>


    // get favoriteMovie and favoriteTv
    @Query("SELECT * FROM movieentities WHERE (id LIKE '%mv%') AND (favorite = 1)") //'true')")
    fun getMovieFavorite(): DataSource.Factory<Int, MovieEntity>//LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities WHERE (id LIKE '%tv%') AND (favorite = 1)") //'true')")
    fun getTvFavorite(): DataSource.Factory<Int, MovieEntity>//LiveData<List<MovieEntity>>


    // query by id for detail Movie/Tv
    @Query("SELECT * FROM movieentities WHERE id = :ids")
    fun getDetailById(ids: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)
}