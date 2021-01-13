@file:JvmName("Converter")
package com.udacity.shoestore.util

import androidx.databinding.InverseMethod

    @InverseMethod("toDouble")
    fun toString(input: Double?): String {
        return input.toString()
    }

    fun toDouble(inStr: String): Double? {
        return when (inStr){
            "" -> null
            else -> inStr.toDouble()
        }
    }
