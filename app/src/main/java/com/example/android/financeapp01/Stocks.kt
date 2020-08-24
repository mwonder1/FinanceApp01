package com.example.android.financeapp01

import android.content.Context
import android.widget.Toast
import kotlin.random.Random

val defaulList = ArrayList<StockItem>()

class Stocks {

    private fun isInList(ticker: String): Boolean {
        for (i in 0 until defaulList.size) {
            if (ticker == defaulList[i].text1) {
                return true
            }
        }
        return false
    }

    fun addStock(adapter: StockAdapter, context: Context, ticker: String) {
        when {
            ticker.isBlank() -> {
                Toast.makeText(context, "Please enter a ticker.", Toast.LENGTH_SHORT).show()
            }
            isInList(ticker) -> {
                Toast.makeText(context, "That ticker is already in your list.", Toast.LENGTH_SHORT)
                    .show()
            }
            else -> {
                val image = R.drawable.ic_arrow_down
                val text2 = "Ticker"
                val price = Random.nextInt(999).toString()
                val newStock = StockItem(image, ticker, text2, price)
                defaulList.add(defaulList.size, newStock)
                adapter.notifyItemInserted(defaulList.size)
                Toast.makeText(context, "You've added $ticker.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}