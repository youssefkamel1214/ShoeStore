package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var price:Double ,var company: String, var description: String,
                var imageurl:String):Parcelable{
                }