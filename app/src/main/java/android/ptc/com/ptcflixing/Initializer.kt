package android.ptc.com.ptcflixing

import android.content.Context
import android.ptc.com.ptcflixing.di.appComponents
import android.ptc.com.ptcflixing.di.networkComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Initializer(val context: Context) {
        fun initKoin(){
                startKoin {
                        androidLogger()
                        androidContext(context)
                        modules(
                                appComponents +
                                        networkComponent
                        )
                }
        }
}