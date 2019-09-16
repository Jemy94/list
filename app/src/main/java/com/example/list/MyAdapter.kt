package com.example.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.my_text

/**
 * Authored by Ahmed Gamal on 16 Sep, 2019.
 *
 */
class MyAdapter : RecyclerView.Adapter<MyHolder>() {

  private val list: MutableList<Int> = mutableListOf()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
    val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
    return MyHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyHolder, position: Int) {
    holder.myText.text = list[position].toString()
  }


  override fun getItemCount(): Int {
    return list.size
  }

  fun update(numbersList: MutableList<Int>?) {
    numbersList?.let {
      list.clear()
      list.addAll(numbersList)
//      notifyItemRangeInserted(0,numbersList.size)
      notifyDataSetChanged()
    }
  }
}

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  var myText = itemView.my_text
}