package com.murugan.bankintest.di.component


import com.murugan.bankintest.di.ViewModelScope
import com.murugan.bankintest.di.module.ViewHolderModule
import com.murugan.bankintest.ui.home.HomeItemViewHolder

import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: HomeItemViewHolder)

}