package com.murugan.bankintest.data.remote

import com.murugan.bankintest.data.remote.response.BikeStandResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.BIKE_STATE)
    fun getBikeStateListCall(): Single<BikeStandResponse>

}