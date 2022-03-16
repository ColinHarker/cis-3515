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

        val images = arrayOf(
            ImageObject(R.drawable.antelope, "Antelope"),
            ImageObject(R.drawable.cute_dog, "Cute Dog"),
            ImageObject(R.drawable.dragon_gheko, "Dragon Gecko"),
            ImageObject(R.drawable.flamingo, "Flamingo"),
            ImageObject(R.drawable.fox_man, "Fox Man"),
            ImageObject(R.drawable.frog, "Frog"),
            ImageObject(R.drawable.giraffe, "Giraffe"),
            ImageObject(R.drawable.leapard, "Leopard"),
            ImageObject(R.drawable.panda, "Panda"),
            ImageObject(R.drawable.possom_man, "Possum Man")
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