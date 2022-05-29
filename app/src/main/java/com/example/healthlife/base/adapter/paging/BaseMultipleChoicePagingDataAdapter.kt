package com.example.healthlife.base.adapter.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding


/**
 * 这是一个支持单选、复选的Paging适配器，使用RecyclerView.Selection 简化多选及状态持久化
 * @param VB : ViewBinding
 * @param T : Any
 * @property selectionTracker SelectionTracker<Long>  recyclerview dlc https://developer.android.google.cn/guide/topics/ui/layout/recyclerview-custom?hl=en
 * @constructor
 */
abstract class BaseMultipleChoicePagingDataAdapter<VB : ViewBinding, T : Any>(diffCallback: DiffUtil.ItemCallback<T>) :
    PagingDataAdapter<T, BaseViewHolder<VB>>(diffCallback) {
    lateinit var selectionTracker: SelectionTracker<Long>
    protected var onItemClickLiveData = MutableLiveData<T>()


    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        // 如果直接在内部类里使用getItem，当删除前面position的item，又不重新走onBindViewHolder，则会引发数组下标越界异常

        val item = getItem(position)
        holder.viewBinding.root.setOnClickListener {
            onItemClickLiveData.setValue(item!!)
        }
    }


    // 对于类似于导航跳转、showToast的UI事件，用此方法直接交给UI component去处理。对于需要数据变动的情况，则应该将Action传递给ItemUiState用于处理点击事件
    /**
     * Gets item click live data.
     *
     * @return the item click live data
     */
    fun getOnItemClickLiveData(): LiveData<T> {
        return onItemClickLiveData
    }


    /**
     * 获取position对应的selection key
     */
    abstract fun getKey(position: Int): Long

    /**
     * 获取selection key对应的position
     */
    abstract fun getPosition(key: Long): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder(
            getViewBinding(
                inflater = LayoutInflater.from(parent.context),
                parent = parent,
                viewType = viewType
            )
        )
    }
    /**
     *  返回 ViewBinding 布局
     * @param inflater LayoutInflater?  布局加载器
     * @param parent ViewGroup
     * @param viewType Int
     * @return VB
     */
    protected abstract fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): VB
}