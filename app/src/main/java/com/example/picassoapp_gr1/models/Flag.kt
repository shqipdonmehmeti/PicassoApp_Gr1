package com.example.picassoapp_gr1.models

import com.google.gson.annotations.SerializedName

data class Flag(
    @SerializedName("png")
    val imageUrl : String?,
    @SerializedName("alt")
    val description : String?
)

data class FlagParent(
    val flags : Flag
)