package com.edd.bimquest.data.model

class PostProvider {

    companion object {

        fun getPost() : PostModel {
            return post[0]
        }

        private val post = listOf<PostModel>(
            PostModel(
                userId = 1,
                id = 1,
                title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
            ),
            PostModel (
                userId = 1,
                id = 2,
                title= "qui est esse",
                body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
            )
        )

    }

}