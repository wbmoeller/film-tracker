package com.wbmoeller.filmtracker.ui.cameras

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.wbmoeller.filmtracker.models.Camera
import com.wbmoeller.filmtracker.repositories.CameraRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CamerasViewModel @ExperimentalCoroutinesApi constructor(
    private val cameraRepository: CameraRepository
) : ViewModel() {

    private val _cameras = MutableLiveData<Result<List<Camera>>>()
    val cameras: LiveData<Result<List<Camera>>> get() = _cameras

    @ExperimentalCoroutinesApi
    fun loadCameras() {
        viewModelScope.launch {
            cameraRepository.fetchCameras()
                .onStart { /* _cameras.value = Result.Loading */ }
                .catch { exception ->
                    _cameras.value = Result.failure(exception)
                }
                .collect { cameraItems ->
                    _cameras.value = Result.success(cameraItems)
                }
            // todo - can't seem to get .asLiveData() to be recognized
        }
    }

    @ExperimentalCoroutinesApi
    class Factory(app: Application) : ViewModelProvider.AndroidViewModelFactory(app) {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CamerasViewModel(CameraRepository()) as T
        }
    }
}