package com.example.duadm_post.ui.home.postFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.duadm_post.R
import com.example.duadm_post.databinding.FragmentPostBinding
import com.example.duadm_post.ui.home.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFragment : Fragment() {

    private lateinit var dataBinding: FragmentPostBinding
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_post, container, false
        )

        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = postViewModel

        postAdapter = PostAdapter()

        dataBinding.recyclerViewPost.layoutManager = LinearLayoutManager(context)
        dataBinding.recyclerViewPost.adapter = postAdapter

        postViewModel.posts.observe(viewLifecycleOwner, Observer { posts ->
            postAdapter.submitList(posts)
        })

        return dataBinding.root
    }
}