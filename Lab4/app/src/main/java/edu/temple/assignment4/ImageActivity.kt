package edu.temple.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        val images = arrayOf(
            ImageObject(R.drawable.bird, "Bird"),
            ImageObject(R.drawable.birdwithfeathers, "Bird with feathers"),
            ImageObject(R.drawable.deer, "Deer"),
            ImageObject(R.drawable.fox, "Fox"),
            ImageObject(R.drawable.lion, "Lion"),
            ImageObject(R.drawable.pandas, "Pandas"),
            ImageObject(R.drawable.rabbit, "Rabbit"),
            ImageObject(R.drawable.sheep, "Sheep"),
            ImageObject(R.drawable.tiger, "Tiger"),
            ImageObject(R.drawable.toucan, "Toucan"),
        )

        val myRecyclerViewFunc = {imageObject:ImageObject ->
            imageView.setImageResource(imageObject.resourceId)
            textView.text = imageObject.description
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = ImageAdapter(images, myRecyclerViewFunc)
    }
}