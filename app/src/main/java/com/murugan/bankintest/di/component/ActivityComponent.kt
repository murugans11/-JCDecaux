package com.murugan.bankintest.di.component

import com.murugan.bankintest.ui.main.MainActivity
import com.murugan.bankintest.di.ActivityScope
import com.murugan.bankintest.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)
}