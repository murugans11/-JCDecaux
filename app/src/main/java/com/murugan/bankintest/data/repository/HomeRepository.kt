package com.murugan.bankintest.data.repository



import com.murugan.bankintest.data.remote.NetworkService
import com.murugan.bankintest.data.remote.response.BikeStandResponseItem
import io.reactivex.Single
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val networkService: NetworkService
) {
    fun getBikeStandList(): Single<List<BikeStandResponseItem>> {
        return networkService.getBikeStateListCall().map { it.toList() }
    }


}