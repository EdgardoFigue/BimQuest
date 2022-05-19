package com.edd.bimquest.data

import com.edd.bimquest.data.model.PostModel
import com.edd.bimquest.data.model.PostProvider
import com.edd.bimquest.data.network.PostService
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val api : PostService,
    private val postProvider: PostProvider
) {

    suspend fun getAllPosts() : List<PostModel> {
        val response : List<PostModel> = api.getPosts()
        postProvider.posts = response
        return response
    }

}