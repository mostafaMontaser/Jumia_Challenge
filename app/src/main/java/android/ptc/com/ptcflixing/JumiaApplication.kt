package android.ptc.com.ptcflixing

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

class JumiaApplication : MultiDexApplication() {
    companion object {
        private var context: Context? = null
        fun getContext() = context
    }
    private lateinit var initializer:Initializer

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initializer=Initializer(this)
        initializer.initKoin()
    }
}

