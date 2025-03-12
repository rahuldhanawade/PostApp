package com.example.duadm_post.ui.home.postFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.duadm_post.R
import com.example.duadm_post.databinding.ItemPostsBinding
import com.example.duadm_post.model.PostDataResponse

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    private var items = mutableListOf<PostDataResponse>()

    fun submitList(post: List<PostDataResponse>){
        items.clear()
        items.addAll(post)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
     return  items.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(items[position], position = position)
    }

    inner class PostViewHolder(private val binding: ItemPostsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: PostDataResponse, position: Int) {
            binding.item = post

            val imageUrl = "https://fastly.picsum.photos/id/866/536/354.jpg?hmac=tGofDTV7tl2rprappPzKFiZ9vDh5MKj39oa2D--gqhA"

            Glide.with(binding.root.context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.itemImg)

            binding.ivFav.setImageResource(
                if (post.isFavorites) R.drawable.ic_heart_fill else R.drawable.ic_heart_outline
            )

            binding.ivFav.setOnClickListener {
                post.isFavorites = !post.isFavorites
                notifyItemChanged(position)
            }

            binding.executePendingBindings()
        }
    }

}
