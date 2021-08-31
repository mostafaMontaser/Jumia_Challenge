package android.ptc.com.ptcflixing.retrofit

import android.ptc.com.ptcflixing.model.request.Constant
import android.ptc.com.ptcflixing.model.retrofit.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    fun getService(): Api =
        Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
}