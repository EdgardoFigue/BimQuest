package com.edd.bimquest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.edd.bimquest.databinding.ActivityMainBinding
import com.edd.bimquest.ui.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postViewModel : PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel.getPost()

        postViewModel.postModel.observe(this, Observer { currentPost ->
            println("GET IN")
            println(currentPost.userId)
        })

    }
}