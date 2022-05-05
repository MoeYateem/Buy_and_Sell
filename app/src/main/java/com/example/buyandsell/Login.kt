package com.example.buyandsell

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.Volley.newRequestQueue
import android.R.layout
import android.content.ContentValues.TAG
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_login.*





class Login : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            var email = " "
            val user_email = findViewById<EditText>(R.id.login_email) //The user email input for the login
            val user_password = findViewById<EditText>(R.id.login_password) //The user password input for the signup

            login_button.setOnClickListener { //button to login

                var url = "http://192.168.232.1/buysellbackend/login.php?email=" + user_email.text.toString() + "&password=" +
                        user_password.text.toString() //adding data to database
                var req: RequestQueue = newRequestQueue(this)
                var str_Req= StringRequest(Request.Method.GET,url, Response.Listener { response ->

                    if(response.equals("0")){
                        //Toast.makeText(this,"Login Failed", Toast.LENGTH_LONG).show()
                        Log.i(TAG, "url: "+url)
                    }

                    else
                    {
                        User_stuff.email=user_email.text.toString()
                        //Toast.makeText(this,"Login Success", Toast.LENGTH_LONG).show()
                        var i=Intent(this,BasedActivity::class.java)
                        startActivity(i)
                    }

                }, Response.ErrorListener { error ->
                    //Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
                })

                req.add(str_Req)
            }
            go_to_signup.setOnClickListener {
                var i=Intent(this,SignupActivity::class.java)
                startActivity(i)
            }





        }
    }





