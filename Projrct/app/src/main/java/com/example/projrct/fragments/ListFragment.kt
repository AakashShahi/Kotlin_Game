package com.example.projrct.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projrct.R
import com.example.projrct.adapters.RecyclerAdapter
import com.example.projrct.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var listBinding:FragmentListBinding
    var title = ArrayList<String>()
    var img= ArrayList<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listBinding= FragmentListBinding.inflate(inflater,container,false)
        title.add("instagram")
        img.add(R.drawable.insta)
        title.add("facebook")
        img.add(R.drawable.fb)
        title.add("twitter")
        img.add(R.drawable.twitter)
        title.add("youtube")
        img.add(R.drawable.youtube)

        var adapter=RecyclerAdapter(title,img)
        listBinding.recyclerView.adapter=adapter
        listBinding.recyclerView.layoutManager= LinearLayoutManager(context)


        return listBinding.root
    }
}