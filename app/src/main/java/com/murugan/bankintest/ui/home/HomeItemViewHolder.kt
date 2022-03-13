package com.murugan.bankintest.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.murugan.bankintest.R
import com.murugan.bankintest.data.remote.response.Resource
import com.murugan.bankintest.di.component.ViewHolderComponent

import com.murugan.bankintest.ui.base.BaseItemViewHolder
import kotlinx.android.synthetic.main.item_view_home.view.*


class HomeItemViewHolder(parent: ViewGroup) :
    BaseItemViewHolder<Resource, HomeItemViewModel>(R.layout.item_view_home, parent) {

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent.inject(this)
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.name.observe(this, Observer {
            itemView.tv_head_line_dummy.text = it
        })


    }

    override fun setupView(view: View) {
        view.setOnClickListener {
            viewModel.onItemClick(adapterPosition)
        }
    }
}