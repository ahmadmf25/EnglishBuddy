package com.dicoding.englishbuddy.ui.bottom_nav.ui.home

import android.app.DirectAction
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dicoding.englishbuddy.databinding.FragmentHomeBinding
import com.dicoding.englishbuddy.ui.listening.ListeningActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val btnListening = binding.btnlistening
        val btnReading = binding.btnReading
        val btnWriting = binding.btnWriting

        btnReading.alpha = 1.0f
        btnListening.alpha = 1.0f
        btnWriting.alpha = 1.0f

        btnListening.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToListening()
            findNavController().navigate(action)
        }

        btnWriting.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToWriting()
            findNavController().navigate(action)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}