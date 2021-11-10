package com.example.dualpanelayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val capitalCityId = intent.extras?.getInt(CAPITAL_CITY_ID, 0) ?: 0

        val detailFragment = supportFragmentManager.findFragmentById(R.id.capital_city_detail) as DetailFragment
        detailFragment.setCapitalCityData(capitalCityId)
    }


}
