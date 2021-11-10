package com.example.dualpanelayouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Context

class ListFragment : Fragment(), View.OnClickListener {

    private lateinit var capitalCityListener: capitalCityListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is capitalCityListener) {
            capitalCityListener = context
        } else {
            throw RuntimeException("Must implement CapitalCityListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val capitalCities = listOf<View>(
            view.findViewById(R.id.canberra),
            view.findViewById(R.id.auckland),
            view.findViewById(R.id.paris),
            view.findViewById(R.id.ottawa),
            view.findViewById(R.id.warsaw),
            view.findViewById(R.id.riga),
            view.findViewById(R.id.london),
            view.findViewById(R.id.lima),
            view.findViewById(R.id.kuala),
            view.findViewById(R.id.pretoria),
            view.findViewById(R.id.lima),
            view.findViewById(R.id.lagos)
        )

        capitalCities.forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {

        v?.let { capitalCity ->
           capitalCityListener.onSelected(capitalCity.id)
        }
    }


}
