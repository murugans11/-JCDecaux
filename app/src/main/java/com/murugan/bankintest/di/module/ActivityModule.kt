package com.murugan.bankintest.di.module


import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.murugan.bankintest.ui.base.BaseActivity
import com.murugan.bankintest.ui.main.MainViewModel
import com.murugan.bankintest.utils.ViewModelProviderFactory
import com.murugan.bankintest.utils.network.NetworkHelper
import com.murugan.bankintest.utils.rx.SchedulerProvider
import dagger.Module


import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MainViewModel = ViewModelProvider(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(MainViewModel::class.java)


}