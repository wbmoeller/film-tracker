package com.wbmoeller.filmtracker.ui.rolls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wbmoeller.filmtracker.databinding.FragmentRollsBinding

class RollsFragment : Fragment() {

    private lateinit var rollsViewModel: RollsViewModel
    private lateinit var binding: FragmentRollsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        rollsViewModel = ViewModelProvider(this).get(RollsViewModel::class.java)
        binding = FragmentRollsBinding.inflate(layoutInflater, container, false)

        rollsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textGallery.text = it
        })

        return binding.root
    }
}
