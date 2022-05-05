package com.example.buyandsell

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class QtFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v= inflater!!.inflate(R.layout.fragment_qt, container, false)

        //var et=v.findViewById<EditText>(R.id.et_qty)
        var btn=v.findViewById<Button>(R.id.btn_qty)

        btn.setOnClickListener {

            var url="http://192.168.232.1/buysellbackend/add_cart.php?email=" + User_stuff.email+"&item_name="+User_stuff.instrument_name


            var rq: RequestQueue = Volley.newRequestQueue(activity)
            var sr= StringRequest(Request.Method.GET,url, Response.Listener { response ->

                //var i= Intent(activity,OrderAct::class.java)
                //startActivity(i)

            },Response.ErrorListener { error ->
                Toast.makeText(activity,error.message,Toast.LENGTH_LONG).show()
            })

            rq.add(sr)

        }

        return v
    }

}