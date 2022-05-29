package com.example.healthlife.base.adapter.paging

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

class LongDetailsLookup(private val recycleView: RecyclerView) :
    ItemDetailsLookup<Long>() {

    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        // NLogger.d("selection", "[itemDetails]lookup details in ${e.x},${e.y}")
        recycleView.findChildViewUnder(e.x, e.y)?.let {
            val holder: RecyclerView.ViewHolder = recycleView.getChildViewHolder(it)
            if (holder is BaseViewHolder<*>) {
                return holder.itemDetails
            }
        }
        return null
    }
}