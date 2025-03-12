package com.example.duadm_post.ui.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.duadm_post.ui.home.favoritesFragment.FavoritesFragment
import com.example.duadm_post.ui.home.postFragment.PostFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PostFragment() // Post Fragment for Posts Tab
            1 -> FavoritesFragment() // Favorite Fragment for Favorites Tab
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }

    override fun getItemCount(): Int = 2 // Two tabs: Posts and Favorites
}