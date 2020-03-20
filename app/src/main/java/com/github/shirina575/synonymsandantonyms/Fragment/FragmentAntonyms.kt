package com.github.shirina575.synonymsandantonyms.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.shirina575.synonymsandantonyms.R

class FragmentAntonyms: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_defination,container,false) //This will inflate the fragment_defination Layout to this fragmentdefination class
    }
}