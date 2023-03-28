package com.example.recycleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val data: Data = Data()

    private lateinit var viewModel: MainViewModel

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.getSize()

    }

    fun setViewModel(v: MainViewModel){
        viewModel = v
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val bound = data.getSize() - 1
        if(viewModel.getTitles()[i].equals("PLACEHOLDER")){
            var value = data.getTitle((0..bound).random())
            viewHolder.itemTitle.text = value
            viewModel.addTitle(value, i)
        }else{
            viewHolder.itemTitle.text = viewModel.getTitles()[i]
        }
        if(viewModel.getDetails()[i].equals("PLACEHOLDER")){
            var value = data.getDetail((0..bound).random())
            viewHolder.itemDetail.text = value
            viewModel.addDetail(value, i)
        }else{
            viewHolder.itemDetail.text = viewModel.getDetails()[i]
        }
        if(viewModel.getImages()[i] == -1){
            var value = data.getImage((0..bound).random())
            viewHolder.itemImage.setImageResource(value)
            viewModel.addImage(value, i)
        }else{
            viewHolder.itemImage.setImageResource(viewModel.getImages()[i])
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()

                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }
}