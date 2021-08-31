package android.ptc.com.ptcflixing.view.search

import android.os.Bundle
import android.ptc.com.ptcflixing.R
import android.ptc.com.ptcflixing.databinding.ActivitySearchBinding
import android.ptc.com.ptcflixing.view.BaseActivity

class SearchActivity : BaseActivity() {
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.layout_container, SearchFragment())
            .commit()
    }

    override fun getContainerId(): Int {
        return R.id.layout_container
    }
}