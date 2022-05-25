package com.example.healthlife.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.example.healthlife.R
import com.example.healthlife.base.fragment.BaseViewBindingFragment
import com.example.healthlife.databinding.FragmentAdvertBinding

class AdvertFragment :
    BaseViewBindingFragment<FragmentAdvertBinding>(FragmentAdvertBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //Handle back event from any fragment
                }
            })
    }

    override fun onResume() {
        super.onResume()
        timer.start()
    }

    private var timer: CountDownTimer = object : CountDownTimer(TOTAL_TIME, ONECE_TIME) {
        override fun onTick(millisUntilFinished: Long) {
            val value: Int = ((millisUntilFinished / 1000).toInt())
            viewBinding.btnSkip.text = getString(R.string.skip, value)
            viewBinding.btnSkip.setOnClickListener {
                if (System.currentTimeMillis() - lastClickTime >= FAST_CLICK_DELAY_TIME) {
                    findNavController().navigate(R.id.homeFragment)
                    lastClickTime = System.currentTimeMillis()
                }
            }
        }

        override fun onFinish() {
            viewBinding.btnSkip.text = "跳过"
            findNavController().navigate(R.id.homeFragment)

        }
    }

    companion object {
        //总计时时间
        private const val TOTAL_TIME = 3000L

        //间隔时间
        private const val ONECE_TIME = 1000L

        //全局定义
        private var lastClickTime = 0L

        // 两次点击间隔不能少于1000ms
        private const val FAST_CLICK_DELAY_TIME = 2000
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }
}