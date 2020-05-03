package com.dotdevs.codextest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dotdevs.codextest.model.StoryResponse
import com.dotdevs.codextest.repository.StoryRepository
import com.dotdevs.codextest.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class StoryViewModel(
    val storyRepository: StoryRepository
): ViewModel() {

    val topStory: MutableLiveData<Resource<List<Int>>> = MutableLiveData()
    val storyDetail: MutableLiveData<Resource<List<StoryResponse>>> = MutableLiveData()

    init {
        getTopStory()
    }

    fun getTopStory() = viewModelScope.launch {
        topStory.postValue(Resource.Loading())
        val response = storyRepository.getTopStories()
        topStory.postValue(handleTopStoryResponse(response))
    }

    fun getStoryDetail(id: Int) = viewModelScope.launch {
        storyDetail.postValue(Resource.Loading())
        val response = storyRepository.getStoryDetail(id)

    }

    private fun handleTopStoryResponse(response: Response<List<Int>>): Resource<List<Int>>{
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }

        return Resource.Error(response.message())
    }

    private fun handleStoryDetailResponse(response: Response<StoryResponse>): Resource<StoryResponse>{
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }

        return Resource.Error(response.message())
    }

}