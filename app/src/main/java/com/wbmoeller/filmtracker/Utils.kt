package com.wbmoeller.filmtracker

fun Double.format(digits: Int) = "%.${digits}f".format(this)