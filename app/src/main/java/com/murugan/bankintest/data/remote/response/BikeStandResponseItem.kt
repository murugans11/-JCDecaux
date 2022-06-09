package com.murugan.bankintest.data.remote.response

data class BikeStandResponseItem(
    val address: String,
    val available_bike_stands: Int,
    val available_bikes: Int,
    val banking: Boolean,
    val bike_stands: Int,
    val bonus: Boolean,
    val contract_name: String,
    val last_update: Long,
    val name: String,
    val number: Int,
    val position: Position,
    val status: String
)