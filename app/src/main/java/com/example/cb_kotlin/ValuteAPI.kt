package com.example.cb_kotlin

import retrofit2.Call
import retrofit2.http.GET

interface ValuteAPI {
    @GET("daily_json.js")
    fun getValute():Call<MValute>
}