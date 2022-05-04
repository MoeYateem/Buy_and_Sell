package com.example.buyandsell

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.instrument_tuple.view.*


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

                UserInfo.itemId=item_id

                var obj=QtyFragment()
                var manager=(itemView.context as Activity).fragmentManager
                obj.show(manager,"Qty")
           // }

        }
    }
}