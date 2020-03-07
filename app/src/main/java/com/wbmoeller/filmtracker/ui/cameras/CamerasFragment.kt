package com.wbmoeller.filmtracker.ui.cameras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wbmoeller.filmtracker.databinding.FragmentCamerasBinding

class CamerasFragment : Fragment() {

    private lateinit var camerasViewModel: CamerasViewModel
    private lateinit var binding: FragmentCamerasBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        camerasViewModel = ViewModelProvider(this).get(CamerasViewModel::class.java)
        binding = FragmentCamerasBinding.inflate(layoutInflater, container, false)
        camerasViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
        return binding.root
    }
}
