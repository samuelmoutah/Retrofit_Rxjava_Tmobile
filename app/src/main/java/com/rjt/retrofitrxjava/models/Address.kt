package com.rjt.retrofitrxjava.models

import com.google.gson.annotations.SerializedName

data class Address (

    @SerializedName("geo")
    var geo: Geo
)