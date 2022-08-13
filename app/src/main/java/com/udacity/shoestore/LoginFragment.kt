package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    lateinit var biding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding= FragmentLoginBinding.inflate(layoutInflater,container,false)
        biding.signbutton.setOnClickListener {
            if (checkinputs()) {
                val action = LoginFragmentDirections.actionLoginFragment2ToWelcomeFragment(
                    biding.emailtext.text.toString(),
                    biding.Nametext.text.toString()
                )
                findNavController().navigate(action)
            }
        }
        biding.loginbutton.setOnClickListener {
            if (checkinputs()) {
                val action = LoginFragmentDirections.actionLoginFragment2ToHomeFragment()
                findNavController().navigate(action)
                findNavController().clearBackStack(R.id.homeFragment)
            }
        }
        return biding.root
    }

    private fun checkinputs(): Boolean {
        var good:Boolean =true
        val email= biding.emailtext.text
        val password= biding.passowrdedittext.text
        if(email.isEmpty()){
            good=false
            biding.emailtext.setError(getString(R.string.error_empty))
        }
        if(password.isEmpty()){
            good=false
            biding.passowrdedittext.setError(getString(R.string.error_empty))
        }
        return  good

    }

}