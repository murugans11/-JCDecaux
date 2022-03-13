package com.murugan.bankintest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.murugan.bankintest.data.repository.HomeRepository
import com.murugan.bankintest.ui.base.BaseViewModel
import com.murugan.bankintest.utils.common.Resource
import com.murugan.bankintest.utils.common.Status
import com.murugan.bankintest.utils.network.NetworkHelper
import com.murugan.bankintest.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val dummyRepository: HomeRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val catagrisLiveData: MutableLiveData<Resource<List<com.murugan.bankintest.data.remote.response.Resource>>> = MutableLiveData()

    fun getDummies(): LiveData<List<com.murugan.bankintest.data.remote.response.Resource>> =
        Transformations.map(catagrisLiveData) { it.data }

    fun isDummiesFetching(): LiveData<Boolean> =
        Transformations.map(catagrisLiveData) { it.status == Status.LOADING }

    override fun onCreate() {
        if (catagrisLiveData.value == null && checkInternetConnectionWithMessage()) {
            catagrisLiveData.postValue(Resource.loading())
            compositeDisposable.add(
                dummyRepository.fetchCaategoriesList()
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { catagrisLiveData.postValue(Resource.success(it)) },
                        {
                            handleNetworkError(it)
                            catagrisLiveData.postValue(Resource.error())
                        })
            )
        }
    }
}