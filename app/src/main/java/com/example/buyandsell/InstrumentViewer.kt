package com.example.buyandsell

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.instrument_tuple.view.*


@Suppress("DEPRECATION")
class InstrumentViewer(var context: Context, var list:ArrayList<Instrument>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ItemHolder).bind(list[position].instrument_name,list[position].instrument_price,list[position].instrument_photo)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.instrument_tuple,parent,false)
        return ItemHolder(v)
    }

    class ItemHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(nm:String,prc:Double,ur:String)
        {
            itemView.item_name.text=nm
            itemView.item_price.text=prc.toString()
            var web:String="http://192.168.232.1/buysellbackend/Pics/"+ur
            //Log.i(TAG, "bind: soura w kaza: $web")
            //web=web.replace(" ","%20")
            //Log.i(TAG, "bind: soura w kaza: $web")
            Picasso.get().load(web).into(itemView.item_photo)


            itemView.item_add_photo.setOnClickListener {

                User_stuff.instrument_name=nm
                Log.i(TAG, "bind: instru name:"+  User_stuff.instrument_name)
                var url="http://192.168.232.1/buysellbackend/add_cart.php?email=" + User_stuff.email+"&item_name="+User_stuff.instrument_name
                var rq: RequestQueue = Volley.newRequestQueue(itemView.context)
                var sr= StringRequest(Request.Method.GET,url, Response.Listener { response ->
                    Log.i(TAG, "bind: barke"+url)
                    //var i=Intent(activity,OrderAct::class.java)
                    //startActivity(i)

                    val i = Intent(itemView.context,CartActivity::class.java)
                    itemView.context.startActivity(i)

                    //var obj=QtFragment()
                    //var manager=(itemView.context as Activity).fragmentManager
                    //obj.show(manager,"Qt")
                    //louay is here
                },Response.ErrorListener { error ->
                    Toast.makeText(itemView.context,error.message,Toast.LENGTH_LONG).show()
                })

                rq.add(sr)
           }

        }
    }
}