package com.edd.bimquest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edd.bimquest.data.model.PostModel
import com.edd.bimquest.domain.GetPostIteractor
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostsIteractor : GetPostIteractor
) : ViewModel() {

    val postModel = MutableLiveData<List<PostModel>>()


    fun onCreate() {
        viewModelScope.launch {
            val result : List<PostModel>? = getPostsIteractor()
            if (!result.isNullOrEmpty()) {
                postModel.postValue(result!!)
            }
        }
    }

}