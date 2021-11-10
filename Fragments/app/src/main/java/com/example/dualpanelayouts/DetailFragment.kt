package com.example.dualpanelayouts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class DetailFragment : Fragment() {

    private val mycountry: TextView?
        get() = view?.findViewById(R.id.thecountry)

    private val myCity: TextView?
        get() = view?.findViewById(R.id.thecapital_city)

    private val mypop: TextView?
        get() = view?.findViewById(R.id.thepopulation)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }



    @SuppressLint("StringFormatInvalid")
    fun setCapitalCityData(capitalCityId: Int) {

        //Some text below should in production be string resources, done as hardcoded text here for simplicity

        when (capitalCityId) {
            R.id.canberra -> {
                myCity?.text = getString(R.string.canberra)
                mycountry?.text = getString(R.string.country, "Australia")
                mypop?.text = getString(R.string.population, "8000000")
            }




            R.id.auckland -> {
                myCity?.text = getString(R.string.canberra)
                mycountry?.text = getString(R.string.country, "New Zealand")
                mypop?.text = getString(R.string.population, "450,888")
            }

            R.id.lagos -> {
                myCity?.text = getString(R.string.lagos)
                mycountry?.text = getString(R.string.country, "Nigeria")
                mypop?.text = getString(R.string.population, "21,320,000")
            }

            R.id.canberra -> {
                myCity?.text = getString(R.string.canberra)
                mycountry?.text = getString(R.string.country, "Water Carrier")
                mypop?.text = getString(R.string.population, "January 20 - February 18")
            }

            else -> {
                Toast.makeText(context, getString(R.string.unknown_capital), Toast.LENGTH_LONG)
                    .show();
            }
        }

    }

}
