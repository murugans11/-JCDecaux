package com.murugan.bankintest.data.remote

import com.murugan.bankintest.data.remote.response.BankingResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.BANKING_CATEGORIES)
    fun getBankingGategoriesListCall(): Single<BankingResponse>

}