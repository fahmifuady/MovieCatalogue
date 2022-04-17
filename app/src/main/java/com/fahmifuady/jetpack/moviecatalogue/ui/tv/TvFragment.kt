package com.fahmifuady.jetpack.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahmifuady.jetpack.moviecatalogue.databinding.FragmentTvBinding
import com.fahmifuady.jetpack.moviecatalogue.viewmodel.ViewModelFactory
import com.fahmifuady.jetpack.moviecatalogue.vo.Status


/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment() {

    private lateinit var fragmentTvBinding: FragmentTvBinding

    private val binding get() = fragmentTvBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java] //val tv = viewModel.getTv()

            val tvAdapter = TvAdapter()

            fragmentTvBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTv().observe(this, {tvs ->
                if (tvs != null) {
                    when (tvs.status) {
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            tvAdapter.submitList(tvs.data)
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvBinding.rvTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }
}