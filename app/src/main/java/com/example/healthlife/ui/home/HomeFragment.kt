package com.example.healthlife.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.bumptech.glide.Glide
import com.example.healthlife.R
import com.example.healthlife.base.fragment.BaseViewBindingFragment
import com.example.healthlife.databinding.FragmentHomeBinding
import com.example.healthlife.uistate.FeatureUiState
import com.youth.banner.Banner
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator

class HomeFragment : BaseViewBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
   private lateinit var featuresAdapter: FeaturesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnBackPress()
        setListener()
        featuresAdapter = FeaturesAdapter()
        viewBinding.rvFeaturesList.adapter = featuresAdapter
        featuresAdapter.submitList(getFeaturesList())
    }

    private fun getFeaturesList(): MutableList<FeatureUiState> {
        return mutableListOf(
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 0),
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 1),
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 2),
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 3),
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 4),
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 5),
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 6),
            FeatureUiState(R.drawable.ic_mall, getString(R.string.sport_mall), 7)
        )
    }

    private fun setOnBackPress() {
        requireActivity().onBackPressedDispatcher
            .addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        requireActivity().finish()
                    }
                },
            )
    }

    private fun setListener() {
        val banner: Banner<String, BannerImageAdapter<String>> =
            viewBinding.banner as Banner<String, BannerImageAdapter<String>>
        banner.apply {
            addBannerLifecycleObserver(viewLifecycleOwner)
            indicator = CircleIndicator(requireContext())
            setAdapter(object : BannerImageAdapter<String>(imageUrls) {
                override fun onBindView(
                    holder: BannerImageHolder,
                    data: String,
                    position: Int,
                    size: Int
                ) {
                    Glide.with(requireContext())
                        .load(data)
                        .into(holder.imageView)
                }
            })

            banner.setOnBannerListener { data, position ->
                logger.d(TAG, "data : $data")
                Toast.makeText(
                    requireContext(),
                    "点击了当前第 $position 个",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        const val TAG = "HomeFragment"
        val imageUrls = listOf(
            "https://img.zcool.cn/community/01b72057a7e0790000018c1bf4fce0.png",
            "https://img.zcool.cn/community/016a2256fb63006ac7257948f83349.jpg",
            "https://img.zcool.cn/community/01233056fb62fe32f875a9447400e1.jpg",
            "https://img.zcool.cn/community/01700557a7f42f0000018c1bd6eb23.jpg"
        )
    }

}