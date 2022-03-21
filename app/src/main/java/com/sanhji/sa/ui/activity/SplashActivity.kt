package com.sanhji.sa.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.dakulangsakalam.customwebview.presentation.utils.writeLogs
import com.sanhji.sa.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashActivity : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            splashAction { version, url ->
                writeLogs("Version: $version \n Url: $url")
                startActivity(MainActivity.createIntent(this@SplashActivity))
                finish()
            }
        }, 1500)
    }
}
