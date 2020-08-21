package com.example.android.financeapp01

import android.content.Context
import android.widget.Toast

val list = ArrayList<StockItem>()

class Stocks {
    fun generateDummyList(size: Int): ArrayList<StockItem> {
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


    private fun isInList(ticker: String): Boolean {
        for (i in 0 until list.size) {
            return ticker == list[i].text1
        }
    }


    fun addStock(adapter: StockAdapter, context: Context, ticker: String) {
        if (ticker.isBlank()) {
            Toast.makeText(context, "Please enter a ticker.", Toast.LENGTH_SHORT).show()
        } else if (isInList(ticker)) {
            Toast.makeText(context, "That ticker is already in your list.", Toast.LENGTH_SHORT)
                .show()
        } else {
            val image = R.drawable.ic_arrow_down
            val text2 = "Ticker"
            val newStock = StockItem(image, ticker, text2)
            list.add(list.size, newStock)
            adapter.notifyItemInserted(list.size)
            Toast.makeText(context, "You've added $ticker.", Toast.LENGTH_SHORT).show()
        }
    }


}