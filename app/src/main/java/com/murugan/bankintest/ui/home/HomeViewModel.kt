package com.murugan.bankintest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.murugan.bankintest.data.remote.response.BikeStandResponseItem
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
    private val homeRepository: HomeRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val mutableLiveData: MutableLiveData<Resource<List<BikeStandResponseItem>>> = MutableLiveData()

    fun getBikeStandList(): LiveData<List<BikeStandResponseItem>> =
        Transformations.map(mutableLiveData) { it.data }

    fun isFetching(): LiveData<Boolean> =
        Transformations.map(mutableLiveData) { it.status == Status.LOADING }

    override fun onCreate() {
        if (mutableLiveData.value == null && checkInternetConnectionWithMessage()) {
            mutableLiveData.postValue(Resource.loading())
            compositeDisposable.add(
                homeRepository.getBikeStandList()
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { mutableLiveData.postValue(Resource.success(it)) },
                        {
                            handleNetworkError(it)
                            mutableLiveData.postValue(Resource.error())
                        })
            )
        }
    }
}