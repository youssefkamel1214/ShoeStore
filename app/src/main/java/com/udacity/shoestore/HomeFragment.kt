package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.databinding.ShoeslayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeVeiwmodel


class HomeFragment : Fragment() {

    lateinit var viewmodel:ShoeVeiwmodel
    lateinit var biding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        biding= FragmentHomeBinding.inflate(layoutInflater,container,false)
        viewmodel= ViewModelProvider(requireActivity())[ShoeVeiwmodel::class.java]
        viewmodel.Shoelist.observe(viewLifecycleOwner , {
            if(it!=null)
                createshoelayout(it)
        })
        biding.addbutton.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToAddShoeFragment()
            findNavController().navigate(action)
        }
        setHasOptionsMenu(true)
        return biding.root
    }

    private fun createshoelayout(shoes: ArrayList<Shoe>) {
        biding.linearlayout.removeAllViews()
        for (shoe:Shoe in shoes){
            val shoebiding:ShoeslayoutBinding= ShoeslayoutBinding.inflate(layoutInflater)
            shoebiding.shoes=shoe
            shoebiding.pricetext.text= String.format("%.2f",shoe.price)
            shoebiding.sizetext.text= String.format("%.2f",shoe.size)
            Glide.with(requireContext()).load(shoe.imageurl).placeholder(R.drawable.shoes_logo).into(shoebiding.shoesimage)
            biding.linearlayout.addView(shoebiding.root)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.logout) {
            val action=HomeFragmentDirections.actionHomeFragmentToLoginFragment2()
            findNavController().navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }
}

