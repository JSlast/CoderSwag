package com.lastsomm.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.lastsomm.coderswag.Adapters.ProductsAdapter
import com.lastsomm.coderswag.R
import com.lastsomm.coderswag.Services.DataService
import com.lastsomm.coderswag.Utilities.Extra_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(Extra_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        val screenSize =resources.configuration.screenWidthDp
        if (screenSize >720){
            spanCount = 3
        }


        val layoutManager = GridLayoutManager (this, 2)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
