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
    private var _loadedRoll: Roll? = null
    val loadedRoll get() = _loadedRoll

    fun load(film: Film): Roll? {
        return if (film.format == filmFormat) {
            val newRoll = Roll(film, this)
            _loadedRoll = newRoll
            newRoll
        } else {
            // error!
            null
        }
    }

    fun unload(): Roll? {
        _loadedRoll?.state = Roll.State.Used
        _loadedRoll = null
        return _loadedRoll
    }
}
