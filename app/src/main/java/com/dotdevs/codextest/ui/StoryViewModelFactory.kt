package com.dotdevs.codextest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dotdevs.codextest.repository.StoryRepository

class StoryViewModelFactory(val storyRepository: StoryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StoryViewModel(storyRepository) as T
    }
}