package com.projeto.tvseries.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.projeto.tvseries.R
import com.projeto.tvseries.data.model.ShowItem
import com.projeto.tvseries.databinding.RvShowLayoutAdapterBinding

class ShowAdapter: RecyclerView.Adapter<ShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RvShowLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root)

    private val diffcallback = object : DiffUtil.ItemCallback<ShowItem>(){
        override fun areItemsTheSame(oldItem: ShowItem, newItem: ShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShowItem, newItem: ShowItem): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffcallback)
    var show:List<ShowItem>
    get() = differ.currentList
    set(value){
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RvShowLayoutAdapterBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentShow = show[position]

        holder.binding.apply {
            txvShow.text = currentShow.name
            imageShow.load(currentShow.image.original){
                crossfade(true)
                crossfade(100)
            }
        }
    }

    override fun getItemCount() = show.size
}