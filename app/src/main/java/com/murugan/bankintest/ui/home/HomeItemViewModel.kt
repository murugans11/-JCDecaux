package com.murugan.bankintest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.murugan.bankintest.data.remote.response.Resource
import com.murugan.bankintest.ui.base.BaseItemViewModel

import com.murugan.bankintest.utils.log.Logger

import com.murugan.bankintest.utils.network.NetworkHelper
import com.murugan.bankintest.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


import javax.inject.Inject

class HomeItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<Resource>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "HomeItemViewModel"
    }

    val name: LiveData<String> = Transformations.map(data) { it.name }


    fun onItemClick(position: Int) {
        messageString.postValue(com.murugan.bankintest.utils.common.Resource.success("Category at $position of ${data.value?.name} and parent ${data.value?.parent?.id}"))
        Logger.d(TAG, "onItemClick at $position")
    }

    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }
}