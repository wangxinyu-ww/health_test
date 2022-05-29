package com.example.healthlife.base.adapter

import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding

abstract class BaseSelectionAdapter<VB : ViewBinding, T> : BaseListAdapter<VB, T> {
    protected constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback) {}
    protected constructor(config: AsyncDifferConfig<T>) : super(config) {}

    /**
     * 获取position对应的selection key
     */
    abstract fun getKey(position: Int): String?

    /**
     * 获取selection key对应的position
     */
    abstract fun getPosition(key: String?): Int
}