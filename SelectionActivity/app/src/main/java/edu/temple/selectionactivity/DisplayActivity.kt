package edu.temple.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val imageObject: ImageObject = intent.getSerializableExtra("IMAGE_ID") as ImageObject

        val imageView = findViewById<ImageView>(R.id.imageView2)
        val textView = findViewById<TextView>(R.id.activity2TextView)
        val button = findViewById<Button>(R.id.activity2Button)

        imageView.setImageResource(imageObject.resourceId)
        textView.text = imageObject.description

        button.setOnClickListener{
            setResult(RESULT_OK)
            finish()
        }
    }
}