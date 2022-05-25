package com.example.healthlife.ui.heartRates

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import binding
import com.example.healthlife.R
import com.example.healthlife.databinding.FragmentHeartRateBinding

class HeartRateFragment : Fragment(R.layout.fragment_heart_rate) {
    private val viewBinding: FragmentHeartRateBinding by binding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.textDashboard.text = "心率"
    }

}