package com.wbmoeller.filmtracker.ui.cameras

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wbmoeller.filmtracker.R
import com.wbmoeller.filmtracker.format
import com.wbmoeller.filmtracker.models.Camera
import kotlinx.android.synthetic.main.camera_list_item.view.*

class CameraRecyclerViewAdapter(var context: Activity, val cameraList: List<Camera>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.camera_list_item, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val camera: Camera = cameraList[position]
        val viewHolder =
            holder as RecyclerViewViewHolder
        viewHolder.manufacturer.text = camera.manufacturer
        viewHolder.model.text = camera.model
        viewHolder.minAperture.text = camera.apertureMin.format(1)
        viewHolder.filmFormat.text = camera.filmFormat.toString()
        if (camera.loadedRoll == null) {
            viewHolder.filmState.text = context.getString(R.string.film_state_empty)
            viewHolder.filmState.setTextColor(ContextCompat.getColor(context, R.color.camera_empty))
            viewHolder.loadedFilmManufacturer.visibility = View.GONE
            viewHolder.loadedFilmName.visibility = View.GONE
            viewHolder.loadedFilmType.visibility = View.GONE
            viewHolder.loadedFilmISO.visibility = View.GONE
        } else {
            viewHolder.filmState.text = context.getString(R.string.film_state_loaded)
            viewHolder.filmState.setTextColor(ContextCompat.getColor(context, R.color.camera_loaded))
            viewHolder.loadedFilmManufacturer.text = camera.loadedRoll?.film?.manufacturer
            viewHolder.loadedFilmName.text = camera.loadedRoll?.film?.name
            viewHolder.loadedFilmType.text = camera.loadedRoll?.film?.format.toString()
            viewHolder.loadedFilmISO.text = camera.loadedRoll?.film?.iso.toString()
            viewHolder.loadedFilmManufacturer.visibility = View.VISIBLE
            viewHolder.loadedFilmName.visibility = View.VISIBLE
            viewHolder.loadedFilmType.visibility = View.VISIBLE
            viewHolder.loadedFilmISO.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return cameraList.size
    }

    internal inner class RecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val thumb: ImageView = itemView.thumb
        val manufacturer: TextView = itemView.manufacturer
        val model: TextView = itemView.model
        val minAperture: TextView = itemView.min_aperture
        val filmFormat: TextView = itemView.film_format
        val filmState: TextView = itemView.film_state
        val loadedFilmManufacturer: TextView = itemView.loaded_film_manufacturer
        val loadedFilmName: TextView = itemView.loaded_film_name
        val loadedFilmType: TextView = itemView.loaded_film_type
        val loadedFilmISO: TextView = itemView.loaded_film_iso
    }
}