package xyz.heydarrn.latihanexplicitintent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Orang(
    val nama:String?,
    val umur:Int?,
    val email:String?,
    val kota:String?
) : Parcelable
