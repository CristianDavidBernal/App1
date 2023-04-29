package com.example.nuevo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textoResultado = findViewById<TextView>(R.id.tvTexto)
        val url = "http://198.162.1.9:8000/order/list?response_type=code&client_id=&redirect_uri=%2F"
        val queue= Volley.newRequestQueue(this  )
        val stringRequest = StringRequest(Request.Method.GET,url,Response.Listener { response ->
            textoResultado.text = "La respuesta es: ${response}"
        },  Response.ErrorListener {
                textoResultado.text= "Algo salio mal"
        })

        queue.add(stringRequest)

    }
}