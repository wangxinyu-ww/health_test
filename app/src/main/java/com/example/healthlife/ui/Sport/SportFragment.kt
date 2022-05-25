package com.example.healthlife.ui.Sport

import android.os.Bundle
import android.view.*
import com.example.healthlife.R
import com.example.healthlife.base.fragment.BaseViewModelFragment

class SportFragment : BaseViewModelFragment<SportViewModel>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun layoutId(): Int {
        return R.layout.fragment_sport
    }

    override fun lazyLoadData() {
    }

    override fun initView(savedInstanceState: Bundle?) {


    }

    override fun createObserver() {
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}