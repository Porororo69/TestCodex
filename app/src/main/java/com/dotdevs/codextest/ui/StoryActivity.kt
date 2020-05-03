package com.dotdevs.codextest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dotdevs.codextest.R
import com.dotdevs.codextest.db.StoryDatabase
import com.dotdevs.codextest.repository.StoryRepository

class StoryActivity : AppCompatActivity() {

    lateinit var viewModel: StoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storyRepository = StoryRepository(StoryDatabase(this))
        val viewModelProviderFactory = StoryViewModelFactory(storyRepository)

        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(StoryViewModel::class.java)
    }
}
