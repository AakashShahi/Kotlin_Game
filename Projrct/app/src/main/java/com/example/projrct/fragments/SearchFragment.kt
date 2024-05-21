package com.example.projrct.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.example.projrct.FragmentToActivity
import com.example.projrct.R
import com.example.projrct.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)

        binding.button2.setOnClickListener {
            var email= binding.email.text.toString()
            var pass=binding.pass.text.toString()

            var fragmentoactivity: FragmentToActivity = activity as FragmentToActivity
            fragmentoactivity.setData(email,pass)
        }

        return binding.root
    }


}