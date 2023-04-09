package com.example.coroutineproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var names = ArrayList<String>()

    private lateinit var viewModel: MainViewModel

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return names.size

    }

    fun setViewModel(v: MainViewModel){
        viewModel = v
    }

    fun setNames(nameList : ArrayList<String>){
        names = nameList
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        /*
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
        */
        var value = names[i]
        viewHolder.itemTitle.text = value
    }

    fun add(s: String){
        viewModel.addNames(s)
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView

        init {
            itemTitle = itemView.findViewById(R.id.itemTitle)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()

                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }
}