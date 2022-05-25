package com.example.healthlife.base
import android.util.Log

class UILogger private constructor() {
    fun d(tag: String?, msg: String?) {
        Log.d(tag, msg!!)
    }

    fun e(tag: String?, msg: String?) {
        Log.e(tag, msg!!)
    }

    companion object {
        @JvmStatic
        var instance: UILogger? = null
            get() {
                if (field == null) {
                    synchronized(UILogger::class.java) {
                        if (field == null) {
                            field = UILogger()
                        }
                    }
                }
                return field
            }
            private set
    }
}