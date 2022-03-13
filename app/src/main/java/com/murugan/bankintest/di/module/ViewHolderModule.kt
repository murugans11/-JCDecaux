package com.murugan.bankintest.di.module

import androidx.lifecycle.LifecycleRegistry
import com.murugan.bankintest.di.ViewModelScope
import com.murugan.bankintest.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}