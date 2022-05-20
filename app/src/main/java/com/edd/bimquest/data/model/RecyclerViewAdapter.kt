package com.edd.bimquest.data.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edd.bimquest.R
import com.edd.bimquest.databinding.CardLayoutBinding

class RecyclerViewAdapter (
    private val courseDataArrayList: java.util.ArrayList<RecyclerPostData>,
    private val mcontext: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        // Set the data to textview and imageview.
        val recyclerData = courseDataArrayList[position]
        holder.cardTitle.text = recyclerData.title
        holder.cardBody.text = recyclerData.body
        holder.card_img_opt.setOnClickListener {
            println("IMG SELECTED with ID ${recyclerData.id}" )
        }
        holder.card_msg_opt.setOnClickListener {
            println("MSG SELECTED with ID ${recyclerData.id}" )
        }

    }

    override fun getItemCount(): Int {
        // this method returns the size of recyclerview
        return courseDataArrayList.size
    }

    // View Holder Class to handle Recycler View.
    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardTitle : TextView = itemView.findViewById(R.id.cardTitle)
        val cardBody : TextView = itemView.findViewById(R.id.cardBody)
        val card_img_opt : ImageButton = itemView.findViewById(R.id.card_img_opt)
        val card_msg_opt : ImageButton = itemView.findViewById(R.id.card_msg_opt)

    }

}