package com.edd.bimquest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edd.bimquest.data.model.PostModel
import com.edd.bimquest.data.model.RecyclerPostData
import com.edd.bimquest.data.model.RecyclerViewAdapter
import com.edd.bimquest.databinding.ActivityMainBinding
import com.edd.bimquest.ui.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val postViewModel : PostViewModel by viewModels()
    private var recyclerView: RecyclerView? = null
    private var recyclerDataArrayList: ArrayList<RecyclerPostData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       recyclerView = binding.mainReciclerView
       recyclerDataArrayList = ArrayList()

       postViewModel.onCreate()

        binding.editQuery.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                recyclerDataArrayList!!.clear()
                postViewModel.searchPost(binding.editQuery.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })
        postViewModel.postModel.observe(this, Observer { posts ->
            posts.forEach { currentPost ->
                val post : PostModel = currentPost
                recyclerDataArrayList!!.add(
                    RecyclerPostData (
                        post.title,
                        post.body,
                        post.userId,
                        post.id
                    )
                )
            }
            val adapter = RecyclerViewAdapter(recyclerDataArrayList!!, this)
            val layoutManager = GridLayoutManager(this, 1   )
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.adapter = adapter
        })

    }
}