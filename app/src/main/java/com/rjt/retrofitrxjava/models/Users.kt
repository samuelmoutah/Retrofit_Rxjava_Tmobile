package com.rjt.retrofitrxjava.models

import com.google.gson.annotations.SerializedName

data class Users (
    @SerializedName("address")
    var address : Address,
    @SerializedName("company")
    var company : Company
)