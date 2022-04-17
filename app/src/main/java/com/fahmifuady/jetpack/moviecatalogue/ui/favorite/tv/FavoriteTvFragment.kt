package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.tv

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
import com.fahmifuady.jetpack.moviecatalogue.databinding.FragmentFavoriteTvBinding
import com.fahmifuady.jetpack.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 * Use the [FavoriteTvFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoriteTvFragment : Fragment() {

    private var favoriteTvBinding: FragmentFavoriteTvBinding? = null
    private val binding get() = favoriteTvBinding

    private lateinit var viewModel: FavoriteTvViewModel
    private lateinit var adapter: FavoriteTvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favoriteTvBinding = FragmentFavoriteTvBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvTvFav)

        if (activity != null) {
            val factory =  ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory) [FavoriteTvViewModel::class.java]

            adapter = FavoriteTvAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getFavoriteTv().observe(this, {tv ->
                //adapter.setTvSelected(tv)
                //adapter.notifyDataSetChanged()
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(tv)
            })

            binding?.rvTvFav?.layoutManager = LinearLayoutManager(context)
            binding?.rvTvFav?.setHasFixedSize(true)
            binding?.rvTvFav?.adapter = adapter
        }
    }

/*    override fun onDestroy() {
        super.onDestroy()
        favoriteTvBinding = null
    }*/

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
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

                movieEntity?.let { viewModel.setTvFavorites(it) }

                val snackBar = Snackbar.make(view as View, getString(R.string.message_undo), Snackbar.LENGTH_LONG)
                snackBar.setAction(getString(R.string.message_ok)) { _ ->
                    movieEntity?.let { viewModel.setTvFavorites(it) }
                }
                snackBar.show()
            }
        }

    })
}