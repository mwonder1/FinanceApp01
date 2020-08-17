package com.example.android.financeapp01

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity(), StockAdapter.OnItemClickListener {

    private val exampleList = generateDummyList(15)
    private val adapter = StockAdapter(exampleList, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        rvStocks.adapter = adapter
        rvStocks.layoutManager = LinearLayoutManager(this)
        rvStocks.setHasFixedSize(true)

    }

    fun addStock(view: View) {
        val t = Toast.makeText(this, "You cannot add stocks yet.", Toast.LENGTH_SHORT).show()
    }

    fun removeStock(view: View) {
        val t = Toast.makeText(this, "You cannot remove stocks yet.", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = exampleList[position]
        clickedItem.text1 = "Clicked"
        adapter.notifyItemChanged(position)
    }

    private fun generateDummyList(size: Int): ArrayList<StockItem> {
        val list = ArrayList<StockItem>()
        for (i in 0 until size) {
            val drawable = when (i % 2) {
                0 -> R.drawable.ic_arrow_up
                else -> R.drawable.ic_arrow_down

            }
            val item = StockItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}