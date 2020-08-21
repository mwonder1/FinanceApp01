package com.example.android.financeapp01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity(), StockAdapter.OnItemClickListener {

    private val exampleList = Stocks().generateDummyList(3)
    private val adapter = StockAdapter(exampleList, this)
    private lateinit var addBtn: Button
    private lateinit var editTxt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        rvStocks.adapter = adapter
        rvStocks.layoutManager = LinearLayoutManager(this)
        rvStocks.setHasFixedSize(true)

        editTxt = findViewById(R.id.tickerTxt)
        addBtn = findViewById(R.id.addBtn)

        addBtn.setOnClickListener {
            Stocks().addStock(adapter, this.applicationContext, editTxt.text.toString())
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = exampleList[position]
        clickedItem.text1 = "Clicked"
        adapter.notifyItemChanged(position)
    }


}