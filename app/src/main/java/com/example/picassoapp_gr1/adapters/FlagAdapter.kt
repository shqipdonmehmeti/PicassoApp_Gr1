package com.example.picassoapp_gr1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.picassoapp_gr1.R
import com.example.picassoapp_gr1.models.Flag
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class FlagAdapter(private val list : List<Flag>) : RecyclerView.Adapter<FlagAdapter.FlagViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flag_item,parent,false)
        return FlagViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val flag = list[position]
        Picasso.get()
            .load(flag.imageUrl)
            .error(R.drawable.ic_error)
            .placeholder(R.drawable.ic_flag_placeholder)
            .into(holder.ivFlag)
        holder.tvDescription.text = flag.description

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(flag)
        }
    }

    class FlagViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val ivFlag : CircleImageView = itemView.findViewById(R.id.ivFlag)
        val tvDescription : TextView = itemView.findViewById(R.id.tvDescription)
    }

    var onItemClick : ((Flag) -> Unit)? = null
}