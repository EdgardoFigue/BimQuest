package com.edd.bimquest.data.network

import com.edd.bimquest.core.RetrofitHelper
import com.edd.bimquest.data.model.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostService @Inject constructor(private val api :PostApiClient) {

    suspend fun getPosts() : List<PostModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPost()
            response.body() ?: emptyList()
        }
    }


}