package android.ptc.com.ptcflixing.repository.remote

import android.ptc.com.ptcflixing.model.request.BaseRequestFactory
import android.ptc.com.ptcflixing.model.response.BaseModel
import retrofit2.Response

interface BaseRemoteRepo {
      suspend fun  fetchData(requestFactory: BaseRequestFactory): Response<out BaseModel>?
}