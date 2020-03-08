package com.wbmoeller.filmtracker.models

import java.net.URI

class Camera(
    val manufacturer: String,
    val model: String,
    val year: Int,
    val serialNumber: String?,
    val marketValue: Double?,
    val style: CameraStyle,
    val focalLength: Int,
    val maxShutterSpeed: String,
    val shutterType: ShutterType,
    val apertureMin: Double,
    val apertureMax: Double,
    val weightInGrams: Int,
    val filmFormat: FilmFormat,
    val linkToCameraWiki: URI?,
    val otherLinks: List<URI>? = null,
    val notes: String? = null
) {
    private var loadedRoll: Roll? = null

    fun load(film: Film): Roll? {
        return if (film.format == filmFormat) {
            val newRoll = Roll(film, this)
            loadedRoll = newRoll
            newRoll
        } else {
            // error!
            null
        }
    }

    fun unload(): Roll? {
        loadedRoll?.state = Roll.State.Used
        loadedRoll = null
        return loadedRoll
    }
}
