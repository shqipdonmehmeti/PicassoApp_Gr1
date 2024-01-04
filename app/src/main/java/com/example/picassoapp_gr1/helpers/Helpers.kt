package com.example.picassoapp_gr1.helpers

import android.content.Context
import android.content.SharedPreferences
import com.example.picassoapp_gr1.api.ServiceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Helpers {
    fun provideRetrofitInstance(): ServiceApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://restcountries.com/v3.1/region/europe/")
            .build()
            .create(ServiceApi::class.java)
    }

    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
    }

    fun saveStringToSharedPrefs(context: Context, key: String, value: String) {
        provideSharedPreferences(context).edit().apply {
            putString(key, value)
            apply() // we use instead of commit() to work async (background)
        }
    }

    fun getStringFromSharedPrefs(context: Context, key: String): String? {
        return provideSharedPreferences(context).getString(key, "")
    }

    fun saveIntToSharedPrefs(context: Context, key: String, value: Int) {
        provideSharedPreferences(context).edit().apply {
            putInt(key, value)
            apply()
        }
    }

    fun getIntFromSharedPrefs(context: Context, key: String): Int? {
        return provideSharedPreferences(context).getInt(key, 0)
    }
}