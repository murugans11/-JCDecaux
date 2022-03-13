package com.murugan.bankintest.data.repository



import com.murugan.bankintest.data.remote.NetworkService
import com.murugan.bankintest.data.remote.response.Resource
import io.reactivex.Single
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val networkService: NetworkService
) {
    fun fetchCaategoriesList(): Single<List<Resource>> {
        return networkService.getBankingGategoriesListCall().map { it.resources }
    }


}