package com.example.healthlife.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import com.example.healthlife.R
import com.example.healthlife.base.fragment.BaseViewBindingFragment
import com.example.healthlife.databinding.FragmentSplashBinding
import com.example.healthlife.utils.SharePreferenceUtils


class SplashFragment :
    BaseViewBindingFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.logo_anim_rotate)
        viewBinding.ivAppIcon.startAnimation(animation)
        viewBinding.tvAppName.startAnimation(animation)
        viewBinding.tvAppNameEnglish.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                animation?.cancel()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            })
    }

//    private fun autoIncrease() {
//        val mThread = Thread(Runnable {
//            while (progress <= 100) {
//                progress += 10
//                if (progress > 100) {
//                    break
//                }
//                requireActivity().runOnUiThread(Runnable {
//                    viewBinding.progress.setProgressCompat(progress as Int, true)
//                    if (viewBinding.progress.progress == 100){
//                        lifecycle.coroutineScope.launch {
//                            delay(1000)
//                            timer.start()
//                        }
//                    }
//                })
//                try {
//                    Thread.sleep(200)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//        }
//        )
//        mThread.start()
//    }
    override fun onResume() {
        super.onResume()
    }

    private var timer: CountDownTimer = object : CountDownTimer(4000, 1000) {
        override fun onTick(sin: Long) {
            if (sin / 1000 == 1L) {
                val isFirstRun: Boolean =
                    SharePreferenceUtils.get(requireContext(), "isFirst", true) as Boolean
                logger.d("Splash", "isFirstRun $isFirstRun")
                if (isFirstRun) {
                    findNavController().navigate(R.id.guideFragment)
                    SharePreferenceUtils.put(requireContext(), "isFirst", false)
                } else {
                    if (hasAdv) {
                        findNavController().navigate(R.id.advertFragment)
                        hasAdv = false
                    }
                    findNavController().navigate(R.id.homeFragment)
                    //获取广告缓存，下次使用
                    hasAdv = true

                }
            }
        }

        override fun onFinish() {
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer.cancel()
    }

    companion object {
        private var hasAdv = false
        private var progress = 0
    }

}