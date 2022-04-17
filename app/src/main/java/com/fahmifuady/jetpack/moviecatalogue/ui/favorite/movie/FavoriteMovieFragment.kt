package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahmifuady.jetpack.moviecatalogue.R
import com.fahmifuady.jetpack.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.fahmifuady.jetpack.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteMovieFragment. newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteMovieFragment : Fragment() {

    private var favoriteMovieBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = favoriteMovieBinding

    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvMovieFav)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory) [FavoriteMovieViewModel::class.java]

            adapter = FavoriteMovieAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteMovie().observe(this, {movie ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(movie)
            })

            binding?.rvMovieFav?.layoutManager = LinearLayoutManager(context)
            binding?.rvMovieFav?.setHasFixedSize(true)
            binding?.rvMovieFav?.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movieEntity = adapter.getSwipeData(swipedPosition)

                movieEntity?.let { viewModel.setMovieFavorites(it) }

                val snackBar = Snackbar.make(view as View, getString(R.string.message_undo), Snackbar.LENGTH_LONG)
                snackBar.setAction(getString(R.string.message_ok)) { _ ->
                    movieEntity?.let { viewModel.setMovieFavorites(it) }
                }
                snackBar.show()
            }
        }

    })
}