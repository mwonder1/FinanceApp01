package com.example.android.financeapp01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.stock_item.view.*

class StockAdapter(
    private val stockList: List<StockItem>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<StockAdapter.StockViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.stock_item, parent, false)

        return StockViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val currentItem = stockList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
    }

    override fun getItemCount() = stockList.size

    inner class StockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}