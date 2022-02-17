package edu.temple.myactivityproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        findViewById<Button>(R.id.button2).setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fired", "ActivityB - onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fired", "ActivityB - onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Fired", "ActivityB - onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fired", "ActivityB - onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fired", "oActivityB - nDestroy()")
    }
}