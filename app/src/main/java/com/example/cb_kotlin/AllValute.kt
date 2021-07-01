package com.example.cb_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.cb_kotlin.AUD as AUD1
import com.example.cb_kotlin.Valute as Valute1

class AllValute : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_valute)

        val bottomNav : BottomNavigationView
        bottomNav = findViewById(R.id.bottom_navigation)
        bottomNav.setSelectedItemId(R.id.all_valute)

        bottomNav.setOnNavigationItemSelectedListener { item: MenuItem ->
            when ( item.itemId){
                R.id.basic_valute -> startActivity(Intent(applicationContext, MainActivity::class.java))
                R.id.quotation -> startActivity(Intent(applicationContext, Quotation::class.java))
            }
            false
        }

    }
}