package com.cic.myapplication

import android.graphics.Bitmap
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import java.lang.Exception
import java.lang.ref.WeakReference

open class Algorithm(progressBar: ProgressBar?) : AsyncTask<Int?, Void?, Double?>() {

    protected var progressBarReference: WeakReference<ProgressBar>? = null

    init {
        try {
            if (progressBar != null)
                progressBarReference = WeakReference(progressBar)
        } catch (e: Exception) {
            // Escribir el mensaje de error en el log.
            Log.e("Algorithm", "Ocurrió un error en la creación del mapa de bits$e")
        }
    }

    override fun doInBackground(vararg p0: Int?): Double? {
        TODO("Not yet implemented")
    }
}