package com.example.duadm_post.ui.home.favoritesFragment

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.duadm_post.R
import com.example.duadm_post.databinding.FragmentFavoritesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private lateinit var dataBinding: FragmentFavoritesBinding
    private val viewModel: FavoritesViewModel by viewModels()
    private lateinit var adapter: FavoritesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorites, container, false
        )

//        dataBinding.lifecycleOwner = viewLifecycleOwner
//        dataBinding.viewModel = viewModel


        return dataBinding.root
    }
}