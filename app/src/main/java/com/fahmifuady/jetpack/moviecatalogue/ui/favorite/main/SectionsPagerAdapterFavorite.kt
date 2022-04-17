package com.fahmifuady.jetpack.moviecatalogue.ui.favorite.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fahmifuady.jetpack.moviecatalogue.R
import com.fahmifuady.jetpack.moviecatalogue.ui.favorite.movie.FavoriteMovieFragment
import com.fahmifuady.jetpack.moviecatalogue.ui.favorite.tv.FavoriteTvFragment

class SectionsPagerAdapterFavorite(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val tabTitle = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvFragment()
            else -> Fragment()
        }

    override fun getCount(): Int = tabTitle.size

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(tabTitle[position])
}