package edu.temple.selectionactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_images: Array<ImageObject>, _myRecyclerViewFunc: (ImageObject) -> Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val images = _images
    val myRecyclerViewFunc = _myRecyclerViewFunc

    inner class ImageViewHolder(_view: View) : RecyclerView.ViewHolder(_view){

        val previewImageView: ImageView = _view.findViewById<ImageView>(R.id.imageView)
        val previewTextDescription: TextView = _view.findViewById<TextView>(R.id.imageTextView)

        lateinit var imageObject: ImageObject
        init {
            _view.setOnClickListener{myRecyclerViewFunc(imageObject)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_with_description, parent, false)

        return ImageViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.previewImageView.setImageResource(images[position].resourceId)
        holder.previewTextDescription.text = images[position].description

        holder.imageObject = images[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}