package com.lastsomm.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.lastsomm.coderswag.Adapters.CategoryRecycleAdapter
import com.lastsomm.coderswag.Model.Category
import com.lastsomm.coderswag.R
import com.lastsomm.coderswag.Services.DataService
import com.lastsomm.coderswag.Utilities.Extra_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this,DataService.categories){ category ->
        val productIntent = Intent (this, ProductsActivity::class.java)
            productIntent.putExtra(Extra_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager (this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }

}
