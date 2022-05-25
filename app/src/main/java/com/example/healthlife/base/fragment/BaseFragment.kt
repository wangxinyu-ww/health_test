package com.example.healthlife.base.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.healthlife.base.UILogger

abstract class BaseFragment : Fragment() {
    protected val logger: UILogger = UILogger.instance!!

    protected fun findNavController(): NavController {
        return NavHostFragment.findNavController(this)
    }
//    /**
//     * 设置状态栏
//     * 子类需要自定义时重写该方法即可
//     * @return Unit
//     */
//    open fun setStatusBar() {
//        StatusBarUtil.immersive(requireActivity())
//        StatusBarUtil.darkMode(requireActivity(),true)
//    }
}