package com.wbmoeller.filmtracker.models

class Roll(
    val film: Film,
    val camera: Camera
) {
    val id: Int
    var state: State = State.Loaded
    var notes: String? = null
    var photos: List<Photo>? = null

    init {
        // todo - auto increment
        id = 0
    }

    enum class State {
        Loaded,
        Used,
        SentForDevelopment,
        Developed,
        Imported
    }
}