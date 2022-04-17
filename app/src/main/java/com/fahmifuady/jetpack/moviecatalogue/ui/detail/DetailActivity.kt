package com.fahmifuady.jetpack.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.fahmifuady.jetpack.moviecatalogue.R
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.databinding.ActivityDetailBinding
import com.fahmifuady.jetpack.moviecatalogue.viewmodel.ViewModelFactory
import com.fahmifuady.jetpack.moviecatalogue.vo.Status

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val ID_MOVIE = "mv"
        const val ID_TV = "tv"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding
    private val mainBinding get() = activityDetailBinding
    private val detailBinding get() = activityDetailBinding.detailContent

    private lateinit var viewModel: DetailViewModel
    private lateinit var category: List<String>
    private var menu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_MOVIE)
            if (id != null) {

                viewModel.setSelectedItem(id)

                category = id.chunked(2)
                when (category[0]) {
                    ID_MOVIE -> {
                        viewModel.movie.observe(this, {data ->
                            if (data != null) {
                                when (data.status) {
                                    Status.LOADING -> mainBinding.progressBar.visibility = View.VISIBLE
                                    Status.SUCCESS -> if (data.data != null) {
                                        mainBinding.progressBar.visibility = View.INVISIBLE
                                        mainBinding.content.visibility = View.VISIBLE
                                        showDetail(data.data)
                                    }
                                    Status.ERROR -> {
                                        mainBinding.progressBar.visibility = View.GONE
                                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        })
                    }

                    ID_TV -> {
                        viewModel.tv.observe(this, {data ->
                            if (data != null) {
                                when (data.status) {
                                    Status.LOADING -> mainBinding.progressBar.visibility = View.VISIBLE
                                    Status.SUCCESS -> if (data.data != null) {
                                        mainBinding.progressBar.visibility = View.INVISIBLE
                                        mainBinding.content.visibility = View.VISIBLE
                                        showDetail(data.data)
                                    }
                                    Status.ERROR -> {
                                        mainBinding.progressBar.visibility = View.GONE
                                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        })
                    }
                }
            }
        }
    }

    private fun showDetail(m: MovieEntity) {
        detailBinding.tvRating.text = m.score
        detailBinding.tvTitle.text = m.title
        detailBinding.tvYear.text = m.year
        detailBinding.tvGenre.text = m.genre
        detailBinding.tvDuration.text = m.duration
        detailBinding.tvOverview.text = m.overview

        detailBinding.imgPoster.let {
            Glide.with(this)
                .load(m.imageUrl)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        when (category[0]) {
            ID_MOVIE -> viewModel.movie.observe(this, { movie ->
                if (movie != null) {
                    when (movie.status) {
                        Status.LOADING -> mainBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (movie.data != null) {
                            mainBinding.progressBar.visibility = View.GONE
                            val state = movie.data.favorite
                            setFavoriteState(state)
                        }
                        Status.ERROR -> {
                            mainBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            ID_TV -> viewModel.tv.observe(this, { tv ->
                if (tv != null) {
                    when (tv.status) {
                        Status.LOADING -> mainBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (tv.data != null) {
                            mainBinding.progressBar.visibility = View.GONE
                            val state = tv.data.favorite
                            setFavoriteState(state)
                        }
                        Status.ERROR -> {
                            mainBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            when(category[0]) {
                ID_MOVIE -> viewModel.setFavoriteMovie()
                ID_TV -> viewModel.setFavoriteTv()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
            Toast.makeText(applicationContext, "Telah ditambahkan ke favorite", Toast.LENGTH_SHORT).show()
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_outline)
            Toast.makeText(applicationContext, "Belum ditambahkan atau telah dihapus dari favorite", Toast.LENGTH_SHORT).show()
        }
    }
}