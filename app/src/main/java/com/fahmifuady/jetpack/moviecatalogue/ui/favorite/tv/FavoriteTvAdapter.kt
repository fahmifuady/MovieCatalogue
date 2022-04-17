package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.tv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fahmifuady.jetpack.moviecatalogue.R
import com.fahmifuady.jetpack.moviecatalogue.data.source.local.entity.MovieEntity
import com.fahmifuady.jetpack.moviecatalogue.databinding.ItemMovieBinding
import com.fahmifuady.jetpack.moviecatalogue.ui.detail.DetailActivity

class FavoriteTvAdapter : PagedListAdapter<MovieEntity, FavoriteTvAdapter.TvViewHolder>(
    DIFF_CALLBACK){

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>(){
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val ft = getItem(position)
        if (ft != null) {
            holder.bind(ft)
        }
    }

    fun getSwipeData(swipePosition: Int): MovieEntity? = getItem(swipePosition)

    class TvViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: MovieEntity) {
            with(binding) {
                tvTitle.text = tv.title
                tvYear.text = tv.year
                tvGenre.text = tv.genre

                Glide.with(itemView.context)
                    .load(tv.imageUrl)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)

                itemView.setOnClickListener {
                    val moveDetail = Intent(itemView.context, DetailActivity::class.java)
                    moveDetail.putExtra(DetailActivity.EXTRA_MOVIE, tv.id)
                    itemView.context.startActivity(moveDetail)
                }
            }
        }
    }
}