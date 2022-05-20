package com.edd.bimquest.domain

import com.edd.bimquest.data.PostRepository
import com.edd.bimquest.data.model.PostModel
import com.edd.bimquest.data.model.PostProvider
import javax.inject.Inject


class GetSearchPostIteractor @Inject constructor(
    private val repository : PostProvider
) {

        operator fun invoke(searchField : String) : List<PostModel> {

           var filtredPost = mutableListOf<PostModel>()

           repository.posts.forEach {
               if (it.title.contains(searchField)) {
                   filtredPost.add(it)
               }
           }
            println("SIZE OF NEW ARRAY " + filtredPost.size)

            return filtredPost
        }

}


