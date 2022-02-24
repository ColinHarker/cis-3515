package edu.temple.activitystate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    var person: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        person = Person("")

        val nameEditText = findViewById<EditText>(R.id.editTextTextPersonName)
        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        val imageView = findViewById<ImageView>(R.id.imageView)

        mainViewModel.getImageId().observe(this){
            imageView.setImageResource(it)
        }

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            person = Person(nameEditText.text.toString())
        }

        findViewById<Button>(R.id.showButton).setOnClickListener {
            person?.run {
                Toast.makeText(this@MainActivity, "Name: $name", Toast.LENGTH_SHORT).show()
            }

        }
        toggleButton.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                mainViewModel.setImageId(if (p1) R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_background)
            }

        })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState?.getString("NAME")?.run {
            person = Person(this)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        person?.run {
            outState.putString("NAME", name)
        }
    }
}