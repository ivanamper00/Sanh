package com.phetmalou.sanh.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.kaiguanjs.utils.YQCUtils
import com.phetmalou.sanh.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val timer = object: CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) { }
            override fun onFinish() {
                YQCUtils.splashAction(this@SplashActivity){ _, _ ->
                    startActivity(MainActivity.createIntent(this@SplashActivity))
                    finish()
                }
            }
        }
        timer.start()
    }
}