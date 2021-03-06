package com.sanhji.sa.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.ui.base.BaseFragment
import com.dakuinternational.common.ui.binding.viewBinding
import com.sanhji.sa.R
import com.sanhji.sa.data.SanhAssets
import com.sanhji.sa.databinding.FragmentDashboardBinding
import com.sanhji.sa.ui.adapter.DashboardAdapter

class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)

    private val delegate by lazy{
        requireActivity() as DashboardAdapter.OnItemClickListener
    }

    private lateinit var data: DataContent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = SanhAssets.types[0]
        binding.item = data

        binding.textView.setOnClickListener {
            delegate.onItemClick(data)
        }

        with(binding.viewPager){

            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3

            adapter = DashboardAdapter(delegate)
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    data = SanhAssets.types[position]
                    binding.item = data

                }
            })

            val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
            val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
            setPageTransformer { page, position ->
                val viewPager = page.parent.parent as ViewPager2
                val offset = position * -(2 * offsetPx + pageMarginPx)
                if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                    if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                        page.translationX = -offset
                    } else {
                        page.translationX = offset
                    }
                } else {
                    page.translationY = offset
                }
            }
        }

    }
}