package com.example.android.financeapp01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_activity.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), StockAdapter.OnItemClickListener {

    private val adapter = StockAdapter(defaulList, this)
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

        val item = object : SwipeFunctions(this, 0, ItemTouchHelper.LEFT) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.swipeDelete(viewHolder.adapterPosition, adapter)
            }
        }

        val itemTouchHelper = ItemTouchHelper(item)
        itemTouchHelper.attachToRecyclerView(rvStocks)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = defaulList[position]
        clickedItem.text3 = Random.nextInt(999).toString()
        adapter.notifyItemChanged(position)
    }
}