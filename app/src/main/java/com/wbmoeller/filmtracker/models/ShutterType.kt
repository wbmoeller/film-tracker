package com.wbmoeller.filmtracker.models

enum class ShutterType {
    Leaf,
    FocalPlane;

    override fun toString(): String {
        return when (this) {
            Leaf -> "Leaf"
            FocalPlane -> "Focal Plane"
        }
    }
}