package com.example.affirmations

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.model.data.Datasource

class MainActivity : AppCompatActivity(),
    ItemAdapter.ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadAffirmations()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ItemAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
        (recyclerView.adapter as? ItemAdapter)?.setItemClickListener(this)
    }

    override fun onItemClick(itemText: String) {
        Toast.makeText(this, itemText, Toast.LENGTH_SHORT).apply {
            show()
        }
    }
}