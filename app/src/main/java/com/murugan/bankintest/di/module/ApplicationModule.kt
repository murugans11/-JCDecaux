package com.murugan.bankintest.di.module

import android.app.Application
import android.content.Context
import com.murugan.bankintest.BuildConfig
import com.murugan.bankintest.BankingApplication
import com.murugan.bankintest.data.remote.NetworkService
import com.murugan.bankintest.data.remote.Networking
import com.murugan.bankintest.di.ApplicationContext
import com.murugan.bankintest.utils.network.NetworkHelper
import com.murugan.bankintest.utils.network.NetworkHelperImpl
import com.murugan.bankintest.utils.rx.SchedulerProvider
import com.murugan.technicaltest.utils.rx.RxSchedulerProvider

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: BankingApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application


    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()


    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(BuildConfig.BASE_URL)

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelperImpl(application)
}