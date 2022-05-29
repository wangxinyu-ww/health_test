package com.example.healthlife.base.adapter.tree;

import android.view.ViewGroup;

import com.example.healthlife.base.adapter.paging.BaseViewHolder;


public abstract class TreeViewBinder<VH extends BaseViewHolder> implements LayoutItemType {
    /**
     * 提供 viewHolder
     *
     * @param parent ViewGroup
     * @return ViewHolder
     */
    public abstract VH provideViewHolder(ViewGroup parent);

    /**
     * 绑定视图
     *
     * @param holder   viewHolder
     * @param position position
     * @param node     node
     */
    public abstract void bindView(VH holder, int position, TreeNode node);
}