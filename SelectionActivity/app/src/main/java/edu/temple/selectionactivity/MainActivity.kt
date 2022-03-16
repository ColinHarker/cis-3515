package edu.temple.selectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myArray = this.resources.getStringArray(R.array.string_array_name)

        val images = arrayOf(
            ImageObject(R.drawable.antelope, myArray[0]),
            ImageObject(R.drawable.cute_dog, myArray[1]),
            ImageObject(R.drawable.dragon_gheko, myArray[2]),
            ImageObject(R.drawable.flamingo, myArray[3]),
            ImageObject(R.drawable.fox_man, myArray[4]),
            ImageObject(R.drawable.frog, myArray[5]),
            ImageObject(R.drawable.giraffe, myArray[6]),
            ImageObject(R.drawable.leapard, myArray[7]),
            ImageObject(R.drawable.panda, myArray[8]),
            ImageObject(R.drawable.possom_man, myArray[9])
        )

        val myRecyclerViewFunc = {imageObject:ImageObject ->
            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("IMAGE_ID", imageObject)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        recyclerView.adapter = ImageAdapter(images, myRecyclerViewFunc)
    }
}