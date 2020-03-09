package com.wbmoeller.filmtracker.models

enum class FilmFormat {
    OneTwenty,
    ThirtyFive,
    Sheet;

    override fun toString(): String {
        return when (this) {
            OneTwenty -> "120"
            ThirtyFive -> "35mm"
            Sheet -> "Sheet"
        }
    }
}
