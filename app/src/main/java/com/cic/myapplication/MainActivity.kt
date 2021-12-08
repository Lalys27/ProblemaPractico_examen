package com.cic.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var btnEnviar: Button
    private lateinit var editTxInput: EditText
    private lateinit var editTxOutput: EditText
    private lateinit var databaseRef: DatabaseReference
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(applicationContext)

        btnEnviar = findViewById(R.id.buttonEnviar)
        editTxInput = findViewById(R.id.editTextInput)
        editTxOutput = findViewById(R.id.editTextOutput)
        progressBar = findViewById(R.id.progressBar)
        databaseRef = Firebase.database.reference


        btnEnviar.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(view: View?) {
                    calcularFactorial()
                }
            }
        )
    }

    fun calcularFactorial(){
        progressBar.setProgress(0)
        var numeric = true
        var num = 0
        val inputText = editTxInput.text.toString()

        //Validacion de dato numerico
        try {
            num = Integer.parseInt(inputText)
        } catch (e: NumberFormatException) {
            numeric = false
        }
        if (!numeric) {
            Toast.makeText(applicationContext, "El valor no es numerico", Toast.LENGTH_LONG).show()
            return
        }
        //Calculo del facotial con AsynTask
        val algorithm = Factorial(progressBar)
        val factorial = algorithm.execute(num).get()
        //Mostrar resultado
        editTxOutput.setText(""+factorial)
        //Guardar resultado en FireBase
        databaseRef.setValue(""+factorial)
    }
}