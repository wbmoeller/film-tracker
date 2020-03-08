package com.wbmoeller.filmtracker.models

import java.net.URI

class Film(
    val manufacturer: String,
    val name: String,
    val format: FilmFormat,
    val iso: Int,
    val color: FilmColor,
    val amazonLink: URI? = null,
    val notes: String? = null
) {

    /*
    - manufacturer
    - Ilford
    - Velvia
- name
    - HP5
    - Delta (Professional)
- format
    - 120
    - 35mm
    - sheet
- iso
    - 50
    - 100
    - 200
- Color
    - Black & White
    - Tungsten
    - Daylight
- amazon link
    - www.amazon.com/…
- observed characteristics
    - soft
    - saturated greens

     */
}