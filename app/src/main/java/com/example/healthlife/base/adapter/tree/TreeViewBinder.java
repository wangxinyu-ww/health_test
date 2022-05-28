package com.example.ui.base.recyclerview.tree;

import android.view.ViewGroup;

import com.pdt.ui.recyclerview.BaseViewHolder;


public abstract class TreeViewBinder<VH extends BaseViewHolder> implements LayoutItemType {
    public abstract VH provideViewHolder(ViewGroup parent);

    public abstract void bindView(VH holder, int position, TreeNode node);
}