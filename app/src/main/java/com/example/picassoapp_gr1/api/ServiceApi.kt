package com.example.picassoapp_gr1.api

import com.example.picassoapp_gr1.models.FlagParent
import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {
    @GET("?fields=flags")
    fun getFlags() : Call<List<FlagParent>>
}