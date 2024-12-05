package com.example.exercice2

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnRouge: Button
    private lateinit var btnVert: Button
    private lateinit var btnBleu: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRouge = findViewById(R.id.ButtonRouge)
        btnBleu = findViewById(R.id.ButtonBleu)
        btnVert = findViewById(R.id.ButtonVert)
        imageView = findViewById(R.id.imageView)

        btnBleu.setOnClickListener {
            imageView.setImageResource(R.drawable.android_blue) // Change l'image
            val myToast = Toast.makeText(this, "Il fait bleu", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.show()
        }

        btnVert.setOnClickListener {
            imageView.setImageResource(R.drawable.android_green) // Change l'image
            val myToast = Toast.makeText(this, "Il fait vert", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.show()
        }

        btnRouge.setOnClickListener {
            imageView.setImageResource(R.drawable.android_red) // Change l'image
            val myToast = Toast.makeText(this, "Il fait rouge", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.show()
        }
    }
}
