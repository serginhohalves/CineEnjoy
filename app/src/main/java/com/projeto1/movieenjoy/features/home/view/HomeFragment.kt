package com.projeto1.movieenjoy.features.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.projeto1.movieenjoy.databinding.FragmentHomeBinding
import com.projeto1.movieenjoy.features.home.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private var binding:FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel // View <=> ViewModel


    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //para usar a viewmodel no fragment
        //precisa ser nao nulo
        activity?.let {
            viewModel = ViewModelProvider(it)[HomeViewModel::class.java]

        //->Aqui estou setando minha vew com a viewmodel
            viewModel.getNowPlayingMovies()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}