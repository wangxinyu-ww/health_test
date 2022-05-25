package com.example.healthlife.base.dialog

import androidx.fragment.app.DialogFragment
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.healthlife.base.UILogger

abstract class BaseDialog : DialogFragment() {
    private val KEY_RESULT = "result"
    protected var logger: UILogger = UILogger.instance!!
    private var previousNavBackStackEntry: NavBackStackEntry? = null

    protected fun findNavController(): NavController {
        return NavHostFragment.findNavController(this)
    }

    override fun onResume() {
        super.onResume()
        previousNavBackStackEntry = findNavController().previousBackStackEntry
    }

    protected fun setNavigationResult(result: Any) {
        logger.d(javaClass.simpleName, "setNavigationResult result = $result")
        if (previousNavBackStackEntry != null) {
            previousNavBackStackEntry!!.savedStateHandle.set(KEY_RESULT, result)
        } else {
            logger.e(javaClass.simpleName, "previous NavBackStackEntry is null")
        }
    }

    protected fun setNavigationResult(key: String, result: Any) {
        logger.d(javaClass.simpleName, "setNavigationResult result = $result, key = $key")
        if (previousNavBackStackEntry != null) {
            previousNavBackStackEntry!!.savedStateHandle.set(key, result)
        } else {
            logger.e(javaClass.simpleName, "previous NavBackStackEntry is null")
        }
    }
}