package com.sanhji.sa.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.navigation.fragment.navArgs
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.ui.base.BaseFragment
import com.dakuinternational.common.ui.binding.viewBinding
import com.dakuinternational.common.ui.delegates.OnImageLoaded
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.ThreeBounce
import com.google.gson.Gson
import com.sanhji.sa.R
import com.sanhji.sa.databinding.FragmentDetailsBinding
import java.lang.Exception


class DetailsFragment : BaseFragment(R.layout.fragment_details), OnImageLoaded {
    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item = Gson().fromJson(args.content, DataContent::class.java)
        binding.imageLoader = this

        val doubleBounce: Sprite = ThreeBounce()
        (binding.spinKit as ProgressBar).indeterminateDrawable = doubleBounce

        binding.backButton.setOnClickListener { onBackPressed() }

    }

    override fun onLoad() {
        try {
            binding.spinKit.visibility = View.GONE
        }catch (e: Exception){}
    }
}