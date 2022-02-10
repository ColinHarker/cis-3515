package edu.temple.coloractivity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<ConstraintLayout>(R.id.ConstraintLayout)

        val spinner = findViewById<Spinner>(R.id.spinner)

        val colors = arrayOf("Select Color", "red", "blue", "green", "black", "white",
            "cyan", "magenta", "yellow", "grey", "aqua", "fuchsia", "lime", "maroon",
            "navy", "olive", "purple", "silver", "teal")

        val adapter = ColorAdapter(this, colors)

        spinner.adapter = adapter


        val eventListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                (spinner.adapter as ColorAdapter).selectedItem = p2
                if(p2 > 0){
                    layout.setBackgroundColor(Color.parseColor(colors[p2]))
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        spinner.onItemSelectedListener = eventListener

    }
}