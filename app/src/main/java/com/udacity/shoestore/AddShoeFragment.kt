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
      var shoee:Shoe=Shoe("",0.0,0.0,"","","")

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
        biding.shoe=shoee
        biding.addbutton.setOnClickListener{
          if(checkinputs()){
              viewmodel.add_shoes(shoee)
              findNavController().navigateUp()

          }
        }
        return biding.root
    }

    private fun checkinputs(): Boolean {
        var good=true
        if (shoee.name.isEmpty()) {
           good = false
            biding.shoesname.error = getString(R.string.error_empty)
        }
        if(shoee.description.isEmpty()) {
           good = false
            biding.shoedescrtiption.error = getString(R.string.error_empty)
        }
        if(shoee.company.isEmpty()){
            good=false
            biding.company.error = getString(R.string.error_empty)
        }
        if(shoee.price==0.0){
            good=false
            biding.size.error = getString(R.string.value_error)
        }
        if(shoee.size==0.0){
            good=false
            biding.size.error = getString(R.string.value_error)
        }
        if(biding.imageurl.text.isEmpty()){
            good=false
            biding.imageurl.error = getString(R.string.error_empty)
        }
       return good
    }

}