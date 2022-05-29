package com.example.healthlife.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.healthlife.base.adapter.BaseListAdapter
import com.example.healthlife.base.adapter.paging.BaseViewHolder
import com.example.healthlife.databinding.ItemFeatureBinding
import com.example.healthlife.uistate.FeatureUiState


class FeaturesAdapter : BaseListAdapter<ItemFeatureBinding, FeatureUiState>(object :
    DiffUtil.ItemCallback<FeatureUiState>() {
    override fun areItemsTheSame(oldItem: FeatureUiState, newItem: FeatureUiState): Boolean {
        return oldItem.imageResId == newItem.imageResId
    }

    override fun areContentsTheSame(oldItem: FeatureUiState, newItem: FeatureUiState): Boolean {
        return oldItem == newItem
    }
}) {

    override fun onBindViewHolder(holder: BaseViewHolder<ItemFeatureBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        val featureUiState: FeatureUiState = getItem(position)

        holder.viewBinding.ivItemFeature.setImageResource(featureUiState.imageResId)
        holder.viewBinding.tvItemFeature.text = (featureUiState.text)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ItemFeatureBinding {
        return ItemFeatureBinding.inflate(inflater, parent, false)
    }


}


