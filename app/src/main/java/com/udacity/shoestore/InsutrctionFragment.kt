package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.databinding.FragmentInsutrctionBinding


class InsutrctionFragment : Fragment() {

    lateinit var biding:FragmentInsutrctionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding= FragmentInsutrctionBinding.inflate(layoutInflater,container,false)
        val instuctionargs by navArgs<InsutrctionFragmentArgs>()
        biding.emailtextstring=getString(R.string.instructiontext1,instuctionargs.email)
        biding.navigatetohomefragment.setOnClickListener{
            val action=InsutrctionFragmentDirections.actionInsutrctionFragmentToHomeFragment()
            findNavController().navigate(action)
        }
        return biding.root
    }


}