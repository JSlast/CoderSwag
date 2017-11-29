package com.lastsomm.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lastsomm.coderswag.R
import com.lastsomm.coderswag.Utilities.Extra_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        intent.getStringExtra(Extra_CATEGORY)
    }
}
