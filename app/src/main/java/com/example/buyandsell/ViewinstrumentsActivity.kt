package com.example.buyandsell

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_viewinstruments.*
import kotlinx.android.synthetic.main.instrument_tuple.view.*

class ViewinstrumentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewinstruments)

        var type:String=(intent.getStringExtra("type")).toString()
        var url= "http://192.168.232.1/buysellbackend/return_instruments.php?type=$type"
        Log.i(TAG, "onCreate: url w kaza: $url")
        var list=ArrayList<Instrument>()

        var req: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(Request.Method.GET,url,null, Response.Listener { response ->

            for(x in 0..response.length()-1){
                list.add(Instrument(response.getJSONObject(x).getString("Pic"),response.getJSONObject(x).getString("Name"),
                    response.getJSONObject(x).getDouble("Price")))
                //Log.i(TAG, "onCreate: pic:"+ response.getJSONObject(x).getString("Pic"))
                //Log.i(TAG, "onCreate: name:"+ response.getJSONObject(x).getString("Name"))
                //Log.i(TAG, "onCreate: Price:"+ response.getJSONObject(x).getDouble("Price"))

            }

            var adp=InstrumentViewer(this,list)
            instrument_rec.layoutManager= LinearLayoutManager(this)
            instrument_rec.adapter=adp

        },Response.ErrorListener { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })
        req.add(jar)
    }
}