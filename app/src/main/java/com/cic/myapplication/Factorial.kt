package com.cic.myapplication

import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import java.lang.ref.WeakReference

class Factorial(progressBar: ProgressBar?) : Algorithm(progressBar) {

    protected override fun doInBackground(vararg params: Int?   ): Double? {
        return calcularFactorial(params[0]!!)
    }


    fun calcularFactorial(num: Int): Double{
        Log.e("Algorithm", "El numero para cacular es: " + num)
        var factorial: Double = 1.0
        for (i in 1..num) {
            factorial *= i.toDouble()
        }
        Log.e("Algorithm", "El numero resultado de factorial es: " + factorial)
        return factorial
    }
}