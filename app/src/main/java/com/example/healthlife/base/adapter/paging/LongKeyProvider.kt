package com.example.healthlife.base.adapter.paging

import android.util.Log
import androidx.recyclerview.selection.ItemKeyProvider

class LongKeyProvider(
    private val adapter: BaseMultipleChoicePagingDataAdapter<*, *>
) : ItemKeyProvider<Long>(SCOPE_MAPPED) {
    companion object {
        private const val TAG = "LongKeyProvider"
    }

    override fun getKey(position: Int): Long {
        Log.d(TAG, "getKey: position = $position")
        return adapter.getKey(position)
    }

    override fun getPosition(key: Long): Int {
        Log.d(TAG, "getPosition: key = $key")
        return adapter.getPosition(key)
    }
}