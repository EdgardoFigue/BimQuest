package com.edd.bimquest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.edd.bimquest.data.model.PostModel
import com.edd.bimquest.databinding.ActivityMainBinding
import com.edd.bimquest.ui.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postViewModel : PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       postViewModel.onCreate()

        postViewModel.postModel.observe(this, Observer { posts ->
            posts.forEach { currentPost ->
                val post : PostModel = currentPost
                println(post.body +  " " + post.id)
            }
        })

    }
}