package com.example.cb_kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://www.cbr-xml-daily.ru/"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var GBP : String
        var USD : String
        var EUR : String

        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        val textView3: TextView = findViewById(R.id.textView3)

        val bottomNav : BottomNavigationView
        bottomNav = findViewById(R.id.bottom_navigation)
        bottomNav.setSelectedItemId(R.id.basic_valute)

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ValuteAPI::class.java)

        val retrofitData = retrofit.getValute()

        retrofitData.enqueue(object : Callback<MValute?> {

            override fun onResponse(call: Call<MValute?>, response: Response<MValute?>) {

                val responseBody = response.body()
                if (responseBody != null) {
                    GBP = responseBody.Valute.GBP.Nominal.toString() + " " + responseBody.Valute.GBP.Name + " = " + responseBody.Valute.GBP.Value + " рублей"
                    USD = responseBody.Valute.USD.Nominal.toString() + " " + responseBody.Valute.USD.Name + " = " + responseBody.Valute.USD.Value + " рублей"
                    EUR = responseBody.Valute.EUR.Nominal.toString() + " " + responseBody.Valute.EUR.Name + " = " + responseBody.Valute.EUR.Value + " рублей"
                    textView.text = GBP
                    textView2.text = USD
                    textView3.text = EUR

                }
            }

            override fun onFailure(call: Call<MValute?>, t: Throwable) {
                Log.d("MainActivity", "Нет подключения к интернету" + t.message)
                val toast = Toast.makeText(applicationContext,"Нет подключения к интернету",Toast.LENGTH_SHORT)
                toast.show()
            }
        })

    bottomNav.setOnNavigationItemSelectedListener { item:MenuItem ->
    when ( item.itemId){
        R.id.all_valute -> startActivity(Intent(applicationContext, AllValute::class.java))
        R.id.quotation -> startActivity(Intent(applicationContext, Quotation::class.java))
                }

        false
            }

        }

    }















