package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeVeiwmodel:ViewModel() {
    private val _Shoelist: MutableLiveData<ArrayList<Shoe>> = MutableLiveData()
    val Shoelist:LiveData<ArrayList<Shoe>> get() =_Shoelist
    init {
        _Shoelist.value= arrayListOf()
    }
    public fun add_shoes(shoe: Shoe){
        _Shoelist.value!!.add(shoe)
        _Shoelist.value=_Shoelist.value
    }
}