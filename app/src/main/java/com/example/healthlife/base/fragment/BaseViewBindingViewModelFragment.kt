package com.example.healthlife.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.viewbinding.ViewBinding
import com.example.healthlife.base.viewmodel.BaseViewModel

abstract class BaseViewBindingViewModelFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val bindingInflater: FragmentViewBindingInflater<VB>
) :
    BaseViewModelFragment<VM>() {
    private var _binding: VB? = null

    protected val viewBinding: VB
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater, container, false)
        return viewBinding.root
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}