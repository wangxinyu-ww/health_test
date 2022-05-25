package com.example.healthlife.utils

import android.content.Context
import android.content.SharedPreferences


object SharePreferenceUtils {
   private const val FILE_NAME = "data"

    /**
     * 保存数据
     *
     * @param context
     * @param key
     * @param object
     */
    fun put(context: Context, key: String?, `object`: Any) {
        val editor = getEditor(context)
        if (`object` is String) {
            editor.putString(key, `object`)
        } else if (`object` is Int) {
            editor.putInt(key, `object`)
        } else if (`object` is Boolean) {
            editor.putBoolean(key, `object`)
        } else if (`object` is Float) {
            editor.putFloat(key, `object`)
        } else if (`object` is Long) {
            editor.putLong(key, `object`)
        } else {
            editor.putString(key, `object`.toString())
        }
        editor.commit()
    }

    /**
     * 获取数据
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    operator fun get(context: Context, key: String?, defaultValue: Any?): Any? {
        val sp: SharedPreferences = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        if (defaultValue is String) {
            return sp.getString(key, defaultValue as String?)
        } else if (defaultValue is Int) {
            return sp.getInt(key, (defaultValue as Int?)!!)
        } else if (defaultValue is Boolean) {
            return sp.getBoolean(key, (defaultValue as Boolean?)!!)
        } else if (defaultValue is Float) {
            return sp.getFloat(key, (defaultValue as Float?)!!)
        } else if (defaultValue is Long) {
            return sp.getLong(key, (defaultValue as Long?)!!)
        }
        return null
    }

    /**
     * remove key
     *
     * @param context
     * @param key
     */
    fun remove(context: Context, key: String?) {
        val editor = getEditor(context)
        editor.remove(key)
        editor.commit()
    }

    /**
     * 判断是否包含key
     *
     * @param context
     * @param key
     * @return
     */
    fun contains(context: Context, key: String?): Boolean {
        val sp: SharedPreferences = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        return sp.contains(key)
    }

    /**
     * 清空数据
     *
     * @param context
     */
    fun clear(context: Context) {
        val editor = getEditor(context)
        editor.clear()
        editor.commit()
    }

    fun getEditor(context: Context): SharedPreferences.Editor {
        val sp: SharedPreferences = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        return sp.edit()
    }
}