package com.example.buyandsell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_based.*

class BasedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_based)

        var url="http://192.168.232.1/buysellbackend/Instrument_type.php"
        var arr=ArrayList<String>()
        var req: RequestQueue = Volley.newRequestQueue(this)
        var jsa= JsonArrayRequest(Request.Method.GET,url,null, Response.Listener { response ->

            for(x in 0..response.length()-1)
                arr.add(response.getJSONObject(x).getString("Type"))

            var adapt= ArrayAdapter(this,R.layout.viewshit,arr)
            instru_type.adapter=adapt

        },Response.ErrorListener { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })
        req.add(jsa)

        instru_type.setOnItemClickListener { adapterView, view, i, l ->

            var cat:String=arr[i]
            //var obj=Intent(this,ItemAct::class.java)
            //obj.putExtra("cat",cat)
            //startActivity(obj)
        }
    }
}