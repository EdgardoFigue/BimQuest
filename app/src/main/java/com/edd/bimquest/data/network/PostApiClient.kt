package com.edd.bimquest.data.network

import com.edd.bimquest.data.model.PostModel
import retrofit2.Response
import retrofit2.http.GET

interface PostApiClient {

    @GET("posts")
    suspend fun getAllPost() : Response<List<PostModel>>

}