package com.murugan.bankintest.ui.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.murugan.bankintest.R
import com.murugan.bankintest.di.component.FragmentComponent
import com.murugan.bankintest.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {

        const val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var bikeStandAdapter: HomeAdapter

    override fun provideLayoutId(): Int = R.layout.fragment_home

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.getBikeStandList().observe(this) {
            it?.run { bikeStandAdapter.appendData(this) }
        }

        viewModel.isFetching().observe(this) {
            pb_loading.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.messageString.observe(this) {
            it.data?.run { showMessage(this) }
        }
    }

    override fun setupView(view: View) {
        rv_bikes.layoutManager = linearLayoutManager
        rv_bikes.adapter = bikeStandAdapter
    }

}