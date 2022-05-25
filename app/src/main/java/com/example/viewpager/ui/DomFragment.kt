package com.example.tableone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tableone.APP_ACTIVITY
import com.example.tableone.Animal
import com.example.tableone.MyAdapter
import com.example.tableone.databinding.FragmentDomBinding




class DomFragment : BasicFragment() {

    private lateinit var binding: FragmentDomBinding
    private lateinit var RV: RecyclerView
    private lateinit var rvAdapter: MyAdapter

    private lateinit var items: ArrayList<Animal>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDomBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        items = ArrayList<Animal>()
        initJSON("ArrayDomestic", items)
        initRV()
    }

    private fun initRV() {
        rvAdapter = MyAdapter(APP_ACTIVITY, items)
        RV = binding.rcDom
        RV.adapter = rvAdapter
        RV.setHasFixedSize(true)
    }

}