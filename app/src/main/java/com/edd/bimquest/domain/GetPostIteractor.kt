package com.edd.bimquest.domain

import com.edd.bimquest.data.PostRepository
import com.edd.bimquest.data.model.PostModel
import javax.inject.Inject

class GetPostIteractor @Inject constructor(
    private val repository : PostRepository
) {

    suspend operator fun invoke() : List<PostModel>? = repository.getAllPosts()

}