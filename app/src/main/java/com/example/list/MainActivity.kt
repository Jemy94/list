package com.example.list

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.next_btn
import kotlinx.android.synthetic.main.activity_main.recycler_view
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main.view.next

class MainActivity : AppCompatActivity() {

  private lateinit var toolBar: Toolbar
  private lateinit var adpater: MyAdapter
  private val myList: List<Int> =
    arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
  private var perPage = 5
  private var count = 5
  private val newList = mutableListOf<Int>()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    toolBar = toolbar
    setSupportActionBar(toolBar)

    toolBar.next.setOnClickListener {
      Toast.makeText(this, "hello", Toast.LENGTH_LONG)
    }


    recycler_view.layoutManager = LinearLayoutManager(this)
    adpater = MyAdapter()
    recycler_view.adapter = adpater
    addFirstPage()

    next_btn.setOnClickListener {
      newList.clear()
      for (item in count..count + 4) {
        if (count + 1 <= myList.size) {
          newList.add(myList[item])
          if (newList.size == 5) {
            adpater.update(newList)
            if (myList.size % perPage == 0) {
              count += 5
            } else {
              for (j in (myList.size - (myList.size % perPage))..myList.size) {
                newList.add(myList[item])
                adpater.update(newList)
              }
            }
          }
        }
      }
    }
  }

  private fun addFirstPage() {
    for (i in 0..4) {
      newList.add(myList[i])
      adpater.update(newList)
    }

  }


}

