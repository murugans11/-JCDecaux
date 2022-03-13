package com.murugan.bankintest.di.module


import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.murugan.bankintest.data.repository.HomeRepository
import com.murugan.bankintest.ui.base.BaseFragment
import com.murugan.bankintest.ui.home.HomeAdapter
import com.murugan.bankintest.utils.ViewModelProviderFactory
import com.murugan.bankintest.utils.network.NetworkHelper
import com.murugan.bankintest.utils.rx.SchedulerProvider
import com.murugan.bankintest.ui.home.HomeViewModel


import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)


    @Provides
    fun provideDummiesViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        dummyRepository: HomeRepository
    ): HomeViewModel =
        ViewModelProvider(fragment,
            ViewModelProviderFactory(HomeViewModel::class) {
                HomeViewModel(
                    schedulerProvider,
                    compositeDisposable,
                    networkHelper,
                    dummyRepository
                )
            }
        ).get(HomeViewModel::class.java)


    @Provides
    fun provideDummiesAdapter() = HomeAdapter(fragment.lifecycle, ArrayList())
}