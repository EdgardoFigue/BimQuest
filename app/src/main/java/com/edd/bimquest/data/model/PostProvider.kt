package com.edd.bimquest.data.model

import javax.inject.Inject

class PostProvider @Inject constructor() {
       var posts : List<PostModel> = emptyList()
}