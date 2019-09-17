package com.example.list

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recycler_view
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main.view.next
import kotlinx.android.synthetic.main.activity_main.view.prev

class MainActivity : AppCompatActivity() {

  private lateinit var toolBar: Toolbar
  private lateinit var adpater: MyAdapter
  private val myList: List<Int> =
    arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 17, 18, 19, 20)
  private var perPage = 5
  private var count = 5
  private val newList = mutableListOf<Int>()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    toolBar = toolbar
    setSupportActionBar(toolBar)




    recycler_view.layoutManager = LinearLayoutManager(this)
    adpater = MyAdapter()
    recycler_view.adapter = adpater
    addFirstPage()

    toolBar.next.setOnClickListener {
      Toast.makeText(this, "hello", Toast.LENGTH_LONG)
      nextPage()
    }

    toolBar.prev.setOnClickListener {
      Toast.makeText(this, "hello", Toast.LENGTH_LONG)
      prevPage()
    }

  }


  private fun addFirstPage() {
    for (i in 0..4) {
      newList.add(myList[i])
      adpater.update(newList)
    }

  }

  private fun nextPage() {
    newList.clear()

    if (myList.size % perPage == 0) {
      for (item in count..count + 4) {

        if (count + 1 <= myList.size) {
          newList.add(myList[item])
          if (newList.size == 5) {
            adpater.update(newList)
            count += 5
          }
        }
      }
    } else {
      if (count == (myList.size - (myList.size % perPage))) {
        for (j in (myList.size - (myList.size % perPage))..(myList.size - 1)) {
          newList.add(myList[j])
          adpater.update(newList)
        }
      } else {
        for (item in count..count + 4) {
          if (count + 1 <= myList.size) {
            newList.add(myList[item])
            if (newList.size == 5) {
              adpater.update(newList)
              count += 5
            }
          }
        }
      }
    }
  }

  private fun prevPage() {
    newList.clear()
    for (item in count - 10..count - 5) {
      if (count - 5 > 0) {
        newList.add(myList[item])
        if (newList.size == 5) {
          adpater.update(newList)
          count -= 5
        }
      }
    }
  }

}

