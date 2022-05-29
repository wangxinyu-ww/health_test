package com.example.healthlife.base.adapter.paging

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * The type View binding view holder.
 *
 * @param <VB> the type parameter
</VB> */
class BaseViewHolder<VB : ViewBinding>(val viewBinding: VB) : RecyclerView.ViewHolder(
    viewBinding.root
) {
    val itemDetails: ItemDetailsLookup.ItemDetails<Long>
        get() = object : ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int {
                return bindingAdapterPosition
            }

            override fun getSelectionKey(): Long? {
                return myItemId
            }

            override fun inSelectionHotspot(e: MotionEvent): Boolean {
                return false
            }
        }
    var myItemId: Long? = itemId
}