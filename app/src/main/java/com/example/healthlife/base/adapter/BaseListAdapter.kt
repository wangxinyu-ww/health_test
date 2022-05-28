package com.example.healthlife.base.adapter

import com.example.healthlife.base.UILogger.Companion.instance
import com.example.healthlife.base.adapter.paging.BaseViewHolder.viewBinding
import androidx.viewbinding.ViewBinding
import com.example.healthlife.base.UILogger
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.AsyncDifferConfig
import android.view.View.OnLongClickListener
import androidx.lifecycle.LiveData
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.ListAdapter
import com.example.healthlife.base.adapter.paging.BaseViewHolder

/**
 * The type Base view binding recycler view adapter.
 *
 *
 * 使用ListAdapter  See [https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter](ListAdapter)
 * 简化函数调用（notifyDataChange)等;
 * 同时可支持Item的点击和长按事件监听
 *
 *
 * @param <VB> the type parameter
</VB> */
abstract class BaseListAdapter<VB : ViewBinding?, T> : ListAdapter<T, BaseViewHolder<VB>> {
    protected val logger = instance
    protected var onItemClickLiveData = MutableLiveData<T?>()
    protected var onItemLongClickLiveData = MutableLiveData<T?>()

    protected constructor(diffCallback: DiffUtil.ItemCallback<T>) : super(diffCallback) {}
    protected constructor(config: AsyncDifferConfig<T>) : super(config) {}

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        // 如果直接在内部类里使用getItem，当删除前面position的item，又不重新走onBindViewHolder，则会引发数组下标越界异常
        val item = getItem(position)
        holder.viewBinding!!.root.setOnClickListener { v: View? -> onItemClickLiveData.setValue(item) }
        holder.viewBinding.root.setOnLongClickListener { v: View? ->
            onItemLongClickLiveData.setValue(item)
            true
        }
    }
    // 对于类似于导航跳转、showToast的UI事件，用此方法直接交给UI component去处理。对于需要数据变动的情况，则应该将Action传递给ItemUiState用于处理点击事件
    /**
     * Gets item click live data.
     *
     * @return the item click live data
     */
    fun getOnItemClickLiveData(): LiveData<T?> {
        return onItemClickLiveData
    }

    /**
     * Gets item long click live data.
     *
     * @return the item long click live data
     */
    fun getOnItemLongClickLiveData(): LiveData<T?> {
        return onItemLongClickLiveData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder(getViewBinding(LayoutInflater.from(parent.context), parent, viewType))
    }

    protected abstract fun getViewBinding(
        inflater: LayoutInflater?,
        parent: ViewGroup,
        viewType: Int
    ): VB
}