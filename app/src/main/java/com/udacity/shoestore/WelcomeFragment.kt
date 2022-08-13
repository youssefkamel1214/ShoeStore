package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    lateinit var biding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding= FragmentWelcomeBinding.inflate(layoutInflater,container,false)
        val welcomeargs by navArgs<WelcomeFragmentArgs>()
        biding.name=welcomeargs.name
        biding.instructiobutton.setOnClickListener {
            val action =
                WelcomeFragmentDirections.actionWelcomeFragmentToInsutrctionFragment(welcomeargs.email)
            findNavController().navigate(action)
        }
        return biding.root
    }

}