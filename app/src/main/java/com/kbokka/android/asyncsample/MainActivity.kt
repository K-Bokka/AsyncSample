package com.kbokka.android.asyncsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val lvCityList = findViewById<ListView>(R.id.lvCityList)
    val cityList: MutableList<MutableMap<String, String>> = mutableListOf()
    cityList.add(mutableMapOf("name" to "東京", "id" to "130010"))
    cityList.add(mutableMapOf("name" to "八丈島", "id" to "130030"))
    cityList.add(mutableMapOf("name" to "大阪", "id" to "270000"))
    cityList.add(mutableMapOf("name" to "神戸", "id" to "280010"))
    cityList.add(mutableMapOf("name" to "豊岡", "id" to "280020"))

    val adapter = SimpleAdapter(
      applicationContext,
      cityList,
      android.R.layout.simple_list_item_1,
      arrayOf("name"),
      intArrayOf(android.R.id.text1)
    )

    lvCityList.adapter = adapter
    lvCityList.onItemClickListener = ListItemClickListener()
  }

  private inner class ListItemClickListener : AdapterView.OnItemClickListener {
    @SuppressLint("SetTextI18n")
    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
      val item = parent.getItemAtPosition(position) as Map<*, *>
      val cityName = item["name"] as String

      val tvCityName = findViewById<TextView>(R.id.tvCityName)
      tvCityName.text = cityName + getString(R.string.suffix_city_weather)
    }
  }
}
