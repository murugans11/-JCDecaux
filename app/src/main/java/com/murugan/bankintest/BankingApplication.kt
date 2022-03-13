package com.murugan.bankintest

import android.app.Application
import com.murugan.bankintest.di.component.ApplicationComponent
import com.murugan.bankintest.di.component.DaggerApplicationComponent
import com.murugan.bankintest.di.module.ApplicationModule

class BankingApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    // Needed to replace the component with a test specific one
    fun setComponent(applicationComponent: ApplicationComponent) {
        this.applicationComponent = applicationComponent
    }
}