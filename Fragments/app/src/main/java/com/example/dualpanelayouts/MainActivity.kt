package com.example.dualpanelayouts

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

const val CAPITAL_CITY_ID = "CAPITAL_CITY_ID"

interface capitalCityListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), capitalCityListener {

    var isDualPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isDualPane = findViewById<View>(R.id.capital_city_detail) != null
    }

    override fun onSelected(id: Int) {

        if (isDualPane) {

            val detailFragment =
                supportFragmentManager.findFragmentById(R.id.capital_city_detail) as DetailFragment
            detailFragment.setCapitalCityData(id)
        } else {
            val detailIntent = Intent(this,  DetailActivity::class.java).apply {
                putExtra(CAPITAL_CITY_ID, id)
            }
            startActivity(detailIntent)
        }
    }
}
