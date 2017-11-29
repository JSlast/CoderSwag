package com.lastsomm.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lastsomm.coderswag.Model.Category
import com.lastsomm.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

/**
 * Created by lastn on 29/11/2017.
 */
class CategoryRecycleAdapter (val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {
    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCatergory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item, parent, false)
        return Holder (view)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCatergory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image,"drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

        }
    }
}
