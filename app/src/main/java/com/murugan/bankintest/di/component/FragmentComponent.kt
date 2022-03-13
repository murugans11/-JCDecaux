package com.murugan.bankintest.di.component

import com.murugan.bankintest.di.FragmentScope
import com.murugan.bankintest.di.module.FragmentModule

import com.murugan.bankintest.ui.home.HomeFragment

import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: HomeFragment)

}