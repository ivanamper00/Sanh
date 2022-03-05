package com.dakuinternational.common.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.dakuinternational.common.ui.dialog.LoadingDialog

abstract class BaseActivity: AppCompatActivity(){

    lateinit var loadingDialog: LoadingDialog;
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        loadingDialog = LoadingDialog(this)
    }

    fun showLoading(isLoading: Boolean){
        if(isLoading) loadingDialog.show()
        else loadingDialog.hide()
    }
}