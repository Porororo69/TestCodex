package com.dotdevs.codextest.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dotdevs.codextest.R
import com.dotdevs.codextest.adapter.StoryAdapter
import com.dotdevs.codextest.ui.StoryActivity
import com.dotdevs.codextest.ui.StoryViewModel
import com.dotdevs.codextest.util.Resource
import kotlinx.android.synthetic.main.fragment_top_story.*

class TopStoryFragment: Fragment(R.layout.fragment_top_story) {

    lateinit var viewModel: StoryViewModel
    lateinit var storyAdapter: StoryAdapter

    private val TAG = "TopStoryFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as StoryActivity).viewModel
        setupRecyclerView()

        viewModel.topStory.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { storyResponse ->
                        storyAdapter.differ.submitList(storyResponse)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })

    }

    private fun hideProgressBar(){

    }

    private fun showProgressBar(){

    }

    private fun setupRecyclerView() {
        storyAdapter = StoryAdapter()
        rvTopStory.apply {
            adapter = storyAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}