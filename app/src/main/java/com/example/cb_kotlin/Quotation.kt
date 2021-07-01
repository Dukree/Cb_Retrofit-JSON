package com.example.cb_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Quotation: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quotation)

        val bottomNav : BottomNavigationView
        bottomNav = findViewById(R.id.bottom_navigation)
        bottomNav.setSelectedItemId(R.id.quotation)

        bottomNav.setOnNavigationItemSelectedListener { item: MenuItem ->
            when ( item.itemId){
                R.id.basic_valute -> startActivity(Intent(applicationContext, MainActivity::class.java))
                 R.id.all_valute -> startActivity(Intent(applicationContext, AllValute::class.java))
            }
            false
        }
    }
}
