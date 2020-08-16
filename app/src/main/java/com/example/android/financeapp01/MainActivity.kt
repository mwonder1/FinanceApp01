package com.example.android.financeapp01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val exampleList = generateDummyList(500)

        rvStocks.adapter = StockAdapter(exampleList)
        rvStocks.layoutManager = LinearLayoutManager(this)
        rvStocks.setHasFixedSize(true)

    }

    private fun generateDummyList(size: Int): List<StockItem> {
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