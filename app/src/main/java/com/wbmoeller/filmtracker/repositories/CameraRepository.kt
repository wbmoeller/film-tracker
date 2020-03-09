package com.wbmoeller.filmtracker.repositories

import android.util.Log
import com.wbmoeller.filmtracker.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.net.URI

@ExperimentalCoroutinesApi
class CameraRepository {

    suspend fun fetchCameras(): Flow<List<Camera>> {
        return flow {
            // simulate network call
            delay(2000)

            // execute API call and map to UI object
            val cameraList = listOf(
                Camera(
                    "Rollei", "Rolleicord V", 1957, null, 240.0, CameraStyle.TLR,
                    80, "1/500", ShutterType.Leaf, 3.5, 22.0, 520, FilmFormat.OneTwenty,
                    URI.create("http://camera-wiki.org/wiki/Rolleicord_V")
                ),
                Camera(
                    "Kodak", "Retina IIa", 1955, null, 120.0, CameraStyle.Rangefinder,
                    55, "1/500", ShutterType.Leaf, 2.0, 22.0, 320, FilmFormat.ThirtyFive,
                    URI.create("http://camera-wiki.org/wiki/Kodak_Retina_IIa")
                ),
                Camera(
                    "Graflex", "Auto Graflex Jr.", 1918, null, 80.0, CameraStyle.SLR,
                    75, "1/1000", ShutterType.FocalPlane, 4.0, 32.0, 410, FilmFormat.OneTwenty,
                    URI.create("http://historiccamera.com/cgi-bin/librarium2/pm.cgi?action=app_display&app=datasheet&app_id=788")
                ),
                Camera(
                    "Bolsey", "C", 1956, null, 80.0, CameraStyle.TLR_Rangefinder,
                    55, "1/500", ShutterType.Leaf, 3.5, 22.0, 410, FilmFormat.ThirtyFive,
                    URI.create("http://camera-wiki.org/wiki/Bolsey_C")
                )
            )

            // Emit the list to the stream
            emit(cameraList)

            // Load the film a bit later
            delay(1000)
            cameraList[2].load(Film("Ilford", "HP5", FilmFormat.OneTwenty, 200, FilmColor.BlackAndWhite))
            emit(cameraList)

            delay(1000)
            cameraList[1].load(Film("Fujifilm", "Velvia", FilmFormat.ThirtyFive, 100, FilmColor.Daylight))
            emit(cameraList)
        }.flowOn(Dispatchers.IO) // Use the IO thread for this Flow
    }
}