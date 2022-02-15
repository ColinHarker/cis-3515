package edu.temple.myactivityproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<Button>(R.id.close).setOnClickListener{

            val resultIntent = Intent()
            resultIntent.putExtra("RESPONSE_DATA", "This is a pie")

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}