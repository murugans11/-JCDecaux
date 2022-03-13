package com.murugan.bankintest.di.component

import android.app.Application
import android.content.Context
import com.murugan.bankintest.BankingApplication
import com.murugan.bankintest.data.remote.NetworkService
import com.murugan.bankintest.di.ApplicationContext
import com.murugan.bankintest.di.module.ApplicationModule
import com.murugan.bankintest.utils.network.NetworkHelper
import com.murugan.bankintest.utils.rx.SchedulerProvider

import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: BankingApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable


}