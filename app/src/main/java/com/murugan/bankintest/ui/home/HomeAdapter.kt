package com.murugan.bankintest.ui.home

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.murugan.bankintest.data.remote.response.Resource


import com.murugan.bankintest.ui.base.BaseAdapter

class HomeAdapter(
    parentLifecycle: Lifecycle,
    private val dummies: ArrayList<Resource>
) : BaseAdapter<Resource, HomeItemViewHolder>(parentLifecycle, dummies) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeItemViewHolder(parent)
}