package com.edd.bimquest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edd.bimquest.data.model.PostModel
import com.edd.bimquest.data.model.PostProvider

class PostViewModel : ViewModel() {

    val postModel = MutableLiveData<PostModel>()

    fun getPost() {
        val post : PostModel = PostProvider.getPost()
        postModel.postValue(post)
    }

}