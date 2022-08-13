package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeVeiwmodel


class AddShoeFragment : Fragment() {
    lateinit var biding:FragmentAddShoeBinding
    lateinit var viewmodel:ShoeVeiwmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        biding= FragmentAddShoeBinding.inflate(layoutInflater,container,false)
        viewmodel= ViewModelProvider(requireActivity())[ShoeVeiwmodel::class.java]
        biding.cancelButton.setOnClickListener{
            findNavController().navigateUp()
        }
        biding.addbutton.setOnClickListener{
          val shoe: Shoe? =getinputs()
          if(shoe!=null){
              viewmodel.add_shoes(shoe)
              findNavController().navigateUp()

          }
        }
        return biding.root
    }

    private fun getinputs(): Shoe? {
        var good:Boolean=true
        if (biding.shoesname.text.isEmpty()) {
           good = false
           biding.shoesname.setError(getString(R.string.error_empty))
        }
        if(biding.shoedescrtiption.text.isEmpty()) {
           good = false
           biding.shoedescrtiption.setError(getString(R.string.error_empty))
        }
        if(biding.company.text.isEmpty()){
            good=false
            biding.company.setError(getString(R.string.error_empty))
        }
        if(biding.size.text.isEmpty()){
            good=false
            biding.size.setError(getString(R.string.error_empty))
        }
        if(biding.price.text.isEmpty()){
            good=false
            biding.price.setError(getString(R.string.error_empty))
        }
        if(biding.imageurl.text.isEmpty()){
            good=false
            biding.imageurl.setError(getString(R.string.error_empty))
        }
        if(!good){
            return null
        }
        else{
            val sizestr = biding.size.text.toString()
            val pricestr = biding.price.text.toString()
            val shoe:Shoe=Shoe(biding.shoesname.text.toString(),sizestr.trim().toDouble(),pricestr.trim().toDouble(),
                biding.company.text.toString(),biding.shoedescrtiption.text.toString(),biding.imageurl.text.trim().toString())
            return shoe
        }
    }

}