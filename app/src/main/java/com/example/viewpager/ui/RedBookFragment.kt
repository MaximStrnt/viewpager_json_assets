package com.example.tableone.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tableone.APP_ACTIVITY
import com.example.tableone.Animal
import com.example.tableone.MyAdapter
import com.example.tableone.databinding.FragmentRedBookBinding


class RedBookFragment : BasicFragment() {

    private lateinit var binding: FragmentRedBookBinding
    private lateinit var RV: RecyclerView
    private lateinit var rvAdapter: MyAdapter

    private lateinit var items: ArrayList<Animal>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRedBookBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        items = ArrayList<Animal>()
        initJSON("ArrayRedBook", items)
        initRV()
    }


    private fun initRV() {
        rvAdapter = MyAdapter(APP_ACTIVITY, items)
        RV = binding.rcRedB
        RV.adapter = rvAdapter
        RV.setHasFixedSize(true)
    }

}