package com.fahmifuady.jetpack.moviecatalogue.utils

import android.content.Context
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.MovieResponse
import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.response.TvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val year = movie.getString("year")
                val duration = movie.getString("duration")
                val score = movie.getString("score")
                val genre = movie.getString("genre")
                val imageUrl = movie.getString("imageUrl")
                val overview = movie.getString("overview")

                val movieResponse = MovieResponse(id, title, year, duration, score, genre, imageUrl, overview, )//favorite)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTv(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvShow")
            for (i in 0 until listArray.length()) {
                val tv = listArray.getJSONObject(i)

                val id = tv.getString("id")
                val title = tv.getString("title")
                val year = tv.getString("year")
                val duration = tv.getString("duration")
                val score = tv.getString("score")
                val genre = tv.getString("genre")
                val imageUrl = tv.getString("imageUrl")
                val overview = tv.getString("overview")

                val tvResponse = TvResponse(id, title, year, duration, score, genre, imageUrl, overview, )//favorite)
                list.add(tvResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}