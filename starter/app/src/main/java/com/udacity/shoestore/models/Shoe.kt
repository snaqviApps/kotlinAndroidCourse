package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
        var name: String,
        var size: Double,
        var company: String,
        var description: String,
        val images: List<String>? = mutableListOf()
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Shoe

        if (name != other.name) return false
        if (size != other.size) return false
        if (company != other.company) return false
        if (description != other.description) return false
        if (images != other.images) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + size.hashCode()
        result = 31 * result + company.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + (images?.hashCode() ?: 0)
        return result
    }
}