package com.murugan.bankintest.ui.main

import androidx.lifecycle.MutableLiveData
import com.murugan.bankintest.ui.base.BaseViewModel
import com.murugan.bankintest.utils.common.Event
import com.murugan.bankintest.utils.network.NetworkHelper
import com.murugan.bankintest.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val homeNavigation = MutableLiveData<Event<Boolean>>()
    val detailsNavigation = MutableLiveData<Event<Boolean>>()

    override fun onCreate() {

    }
}