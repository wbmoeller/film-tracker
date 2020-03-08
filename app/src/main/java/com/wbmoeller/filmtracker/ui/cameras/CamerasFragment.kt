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
        val app = activity?.application
        app?.let {
            camerasViewModel = ViewModelProvider(
                this,
                CamerasViewModel.Factory(it)
            ).get(CamerasViewModel::class.java)
        }
        binding = FragmentCamerasBinding.inflate(layoutInflater, container, false)

        camerasViewModel.cameras.observe(viewLifecycleOwner, Observer {
            when {
                it.isSuccess -> {
                    binding.textHome.text = "CamerasFragment loaded ${it.getOrDefault(listOf()).size}"
                }
                it.isFailure -> {
                    binding.textHome.text = it.exceptionOrNull()?.message
                }
            }
        })

        camerasViewModel.loadCameras()

        // todo - it's like i never actually get the value of the loaded cameras...
        return binding.root
    }
}
