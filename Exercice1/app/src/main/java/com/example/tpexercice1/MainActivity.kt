package com.example.tpexercice1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnRouge: Button
    private lateinit var btnVert: Button
    private lateinit var btnBleu: Button
    private lateinit var myLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRouge = findViewById(R.id.ButtonRouge)
        btnBleu = findViewById(R.id.ButtonBleu)
        btnVert = findViewById(R.id.ButtonVert)
        myLayout = findViewById(R.id.myLayout)

        btnBleu.setOnClickListener {
            myLayout.setBackgroundColor(Color.BLUE)
            val myToast = Toast.makeText(this, "Il fait bleu", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.show()
        }

        btnVert.setOnClickListener {
            myLayout.setBackgroundColor(Color.GREEN)
            val myToast = Toast.makeText(this, "Il fait vert", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.show()
        }

        btnRouge.setOnClickListener {
            myLayout.setBackgroundColor(Color.RED)
            val myToast = Toast.makeText(this, "Il fait rouge", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.CENTER, 0, 0)
            myToast.show()
        }
    }
}
