package com.phetmalou.sanh.ui.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.dakuinternational.common.domain.model.DataContent
import com.dakuinternational.common.ui.ActivityViewModel
import com.dakuinternational.common.ui.base.BaseActivity
import com.dakuinternational.common.ui.dialog.AlertUtils
import com.google.gson.Gson
import com.phetmalou.sanh.R
import com.phetmalou.sanh.databinding.ActivityMainBinding
import com.phetmalou.sanh.ui.adapter.DashboardAdapter
import com.phetmalou.sanh.ui.fragment.DashboardFragment
import com.phetmalou.sanh.ui.fragment.DashboardFragmentDirections

class MainActivity : BaseActivity(), DashboardAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<ActivityViewModel>()
    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.navigation_host) as NavHostFragment
    }
    private val navController get() = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = LayoutInflater.from(this)
        binding = ActivityMainBinding.inflate(inflater, null, false)
        setContentView(binding.root)

    }

    companion object{
        fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onBackPressed() {
        if(navHostFragment.childFragmentManager.backStackEntryCount == 0) {
            AlertUtils.alertExit(this){ p0, p1 ->
                when(p1){
                    DialogInterface.BUTTON_POSITIVE -> super.onBackPressed()
                    else ->  p0.dismiss()
                }
            }.show()
        }else super.onBackPressed()
    }

    override fun onItemClick(data: DataContent) {
        val direction = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(Gson().toJson(data))
        navController.navigate(direction)
    }


}