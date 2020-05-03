package com.dotdevs.codextest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dotdevs.codextest.R
import com.dotdevs.codextest.model.StoryResponse
import kotlinx.android.synthetic.main.item_story_preview.view.*

class StoryAdapter: RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    private val story: StoryResponse? = null

    class StoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object: DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_story_preview,
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = differ.currentList[position]

        holder.itemView.apply {
            testID.text = story.toString()
            setOnClickListener {
                onItemClickListener?.let {
                    it(story)
                }
            }
        }
    }

    private fun fetchStoryDetail(){

    }

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setItemOnClickListener(listener: (Int) -> Unit){
        onItemClickListener = listener
    }
}