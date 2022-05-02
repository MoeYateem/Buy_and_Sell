package com.example.buyandsell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        var email=" ";
        signup_Button.setOnClickListener {

            if(signup_Password.text.toString().equals(password_Confirmation.text.toString())) {
                var url = "http://192.168.232.1/buysellbackend/register.php?email=" + signup_Email.text.toString() + "&password=" +
                        signup_Password.text.toString() + "&name=" + signup_Name.text.toString() + "&address=" + signup_Address.text.toString()
                var rq: RequestQueue = Volley.newRequestQueue(this)
                var sr= StringRequest(Request.Method.GET,url, Response.Listener { response ->
                    if(response.equals("1"))
                        Toast.makeText(this,"Email already associated with an account",Toast.LENGTH_LONG).show()
                    else
                    {
                        email=signup_Email.text.toString()
                        //var i= Intent(this,HomeAct::class.java)
                        //startActivity(i)
                    }

                },Response.ErrorListener { error ->
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
                })

                rq.add(sr)
            }
            else
                Toast.makeText(this,"Password not match",Toast.LENGTH_LONG).show()

        }


    }
}