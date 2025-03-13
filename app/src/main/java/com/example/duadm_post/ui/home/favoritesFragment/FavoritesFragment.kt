package com.example.duadm_post.ui.home.favoritesFragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.InvalidationTracker
import com.example.duadm_post.R
import com.example.duadm_post.databinding.FragmentFavoritesBinding
import com.example.duadm_post.ui.home.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private lateinit var dataBinding: FragmentFavoritesBinding
    private val viewModel: PostViewModel by viewModels()
    private lateinit var adapter: FavoritesAdapter

    private val TAG = "FavoritesFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorites, container, false
        )


        adapter = FavoritesAdapter { post ->
            viewModel.removeFromFavorites(post)
        }

        dataBinding.recyclerViewFavorites.layoutManager = LinearLayoutManager(requireContext())
        dataBinding.recyclerViewFavorites.adapter = adapter

        viewModel.favorites.observe(viewLifecycleOwner,
            Observer { favoritePosts ->
                adapter.submitList(favoritePosts)
            })

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val post = adapter.currentList[viewHolder.bindingAdapterPosition]
                viewModel.removeFromFavorites(post)
            }
        })

        itemTouchHelper.attachToRecyclerView(dataBinding.recyclerViewFavorites)


        return dataBinding.root
    }
}