package android.ptc.com.ptcflixing.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.ptc.com.ptcflixing.R
import android.ptc.com.ptcflixing.databinding.ActivitySplashBinding
import android.ptc.com.ptcflixing.view.BaseActivity
import android.ptc.com.ptcflixing.view.search.SearchActivity

class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val timeMS = 1500L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        animate()
    }

    private fun animate() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, SearchActivity::class.java))
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }, timeMS)
    }
}