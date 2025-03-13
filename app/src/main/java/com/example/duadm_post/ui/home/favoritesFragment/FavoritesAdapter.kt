package com.example.duadm_post.ui.home.favoritesFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.duadm_post.R
import com.example.duadm_post.databinding.ItemPostsBinding
import com.example.duadm_post.model.PostDataResponse

class FavoritesAdapter(
    private val onDeleteClick: (PostDataResponse) -> Unit
) : ListAdapter<PostDataResponse, FavoritesAdapter.FavoriteViewHolder>(PostDiffCallback()) {

    private val TAG = "FavoritesAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemPostsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FavoriteViewHolder(private val binding: ItemPostsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostDataResponse) {
            binding.itemtitle.text = post.title
            binding.itemBody.text = post.body
            val imageUrl = "https://fastly.picsum.photos/id/866/536/354.jpg?hmac=tGofDTV7tl2rprappPzKFiZ9vDh5MKj39oa2D--gqhA"

            Glide.with(binding.root.context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.itemImg)

            binding.ivFav.setImageResource(
                if (post.isFavorites) R.drawable.ic_heart_fill else R.drawable.ic_heart_outline
            )

            binding.ivFav.setOnClickListener {
                onDeleteClick(post)
            }
        }
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<PostDataResponse>() {
    override fun areItemsTheSame(oldItem: PostDataResponse, newItem: PostDataResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostDataResponse, newItem: PostDataResponse): Boolean {
        return oldItem == newItem
    }
}