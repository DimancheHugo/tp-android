package com.example.exercice3

import android.os.Bundle
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var ledImageView: ImageView
    private lateinit var toggleButton: ToggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des éléments
        ledImageView = findViewById(R.id.ledImageView)
        toggleButton = findViewById(R.id.toggleButton)

        // Initialiser le ToggleButton sur OFF au démarrage
        toggleButton.isChecked = false
        ledImageView.setImageResource(R.drawable.led_off)
        toggleButton.text = "OFF"
        toggleButton.setBackgroundResource(R.drawable.toggle_off) // état visuel du bouton OFF

        // Écouteur d'événements pour le ToggleButton
        toggleButton.setOnClickListener {
            // Vérifier l'état du ToggleButton
            if (toggleButton.isChecked) {
                // Si activé, changer l'image à led_on
                ledImageView.setImageResource(R.drawable.led_on)
                toggleButton.text = "ON"
                toggleButton.setBackgroundResource(R.drawable.toggle_on) // état visuel du bouton ON
            } else {
                // Si désactivé, changer l'image à led_off
                ledImageView.setImageResource(R.drawable.led_off)
                toggleButton.text = "OFF"
                toggleButton.setBackgroundResource(R.drawable.toggle_off) // état visuel du bouton OFF
            }
        }
    }
}
