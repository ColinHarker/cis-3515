package edu.temple.assignment4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_images: Array<ImageObject>, _myRecyclerViewFunc: (ImageObject) -> Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val images = _images
    val myRecyclerViewFunc = _myRecyclerViewFunc

    inner class ImageViewHolder(_view: View) : RecyclerView.ViewHolder(_view){

        val previewImageView: ImageView = _view.findViewById<ImageView>(R.id.previewImageView)

        lateinit var imageObject: ImageObject
        init {
            _view.setOnClickListener{myRecyclerViewFunc(imageObject)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_layout, parent, false)

        return ImageViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.previewImageView.setImageResource(images[position].resourceId)

        holder.imageObject = images[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}