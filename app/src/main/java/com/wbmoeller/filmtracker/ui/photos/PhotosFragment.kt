package com.wbmoeller.filmtracker.ui.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wbmoeller.filmtracker.databinding.FragmentPhotosBinding

class PhotosFragment : Fragment() {

    private lateinit var photosViewModel: PhotosViewModel
    private lateinit var binding: FragmentPhotosBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        photosViewModel = ViewModelProvider(this).get(PhotosViewModel::class.java)
        binding = FragmentPhotosBinding.inflate(layoutInflater, container, false)
        photosViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textSlideshow.text = it
        })
        return binding.root
    }
}
