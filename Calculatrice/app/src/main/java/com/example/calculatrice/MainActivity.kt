package com.example.calculatrice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextResult: EditText
    private var currentInput = ""
    private var firstOperand = 0.0
    private var operator = ""
    private var isNewOperation = true  // Pour savoir si c'est une nouvelle opération ou pas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextResult = findViewById(R.id.EditTextResult)

        // Ajout des écouteurs d'événements pour les chiffres
        val numberButtonIds = arrayOf(
            R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9,
            R.id.button0
        )

        for (id in numberButtonIds) {
            findViewById<Button>(id).setOnClickListener(NumberClickListener())
        }

        // Ajout des écouteurs pour les opérateurs
        findViewById<Button>(R.id.buttonAddition).setOnClickListener(
            OperatorClickListener("+")
        )
        findViewById<Button>(R.id.buttonSoustraction).setOnClickListener(
            OperatorClickListener("-")
        )
        findViewById<Button>(R.id.buttonMultiplication).setOnClickListener(
            OperatorClickListener("×")
        )
        findViewById<Button>(R.id.buttonDivision).setOnClickListener(
            OperatorClickListener("÷")
        )

        // Bouton =
        findViewById<Button>(R.id.buttonEgal).setOnClickListener(EqualClickListener())

        // Bouton AC
        findViewById<Button>(R.id.buttonAC).setOnClickListener {
            currentInput = ""
            firstOperand = 0.0
            operator = ""
            editTextResult.setText("0")
            isNewOperation = true  // Réinitialisation pour une nouvelle opération
        }
    }

    // Classe interne pour les chiffres
    private inner class NumberClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            val button = v as Button
            // Si c'est une nouvelle opération, réinitialiser l'affichage
            if (isNewOperation) {
                currentInput = ""
                isNewOperation = false
            }
            currentInput += button.text.toString()
            editTextResult.setText(currentInput)
        }
    }

    // Classe interne pour les opérateurs
    private inner class OperatorClickListener(private val operatorSymbol: String) :
        View.OnClickListener {
        override fun onClick(v: View) {
            if (currentInput.isNotEmpty()) {
                // Effectuer le calcul si un opérateur est déjà stocké
                if (operator.isNotEmpty()) {
                    val secondOperand = currentInput.toDouble()
                    firstOperand = calculate(firstOperand, secondOperand, operator)
                    currentInput = ""  // Réinitialiser le second opérande
                    editTextResult.setText(firstOperand.toString())
                } else {
                    firstOperand = currentInput.toDouble()
                    currentInput = ""
                }
                operator = operatorSymbol
                isNewOperation = true // Préparer pour une nouvelle entrée
            }
        }
    }

    // Classe interne pour le bouton =
    private inner class EqualClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            if (currentInput.isNotEmpty() && operator.isNotEmpty()) {
                val secondOperand = currentInput.toDouble()
                firstOperand = calculate(firstOperand, secondOperand, operator)
                currentInput = firstOperand.toString()
                operator = ""
            }
            editTextResult.setText(currentInput)
        }
    }

    // Fonction pour effectuer un calcul avec un opérateur
    private fun calculate(firstOperand: Double, secondOperand: Double, operator: String): Double {
        return when (operator) {
            "+" -> firstOperand + secondOperand
            "-" -> firstOperand - secondOperand
            "×" -> firstOperand * secondOperand
            "÷" -> if (secondOperand != 0.0) firstOperand / secondOperand else {
                editTextResult.setText("Erreur")
                0.0
            }
            else -> 0.0
        }
    }
}
