package android.ptc.com.ptcflixing.model.retrofit

import android.ptc.com.ptcflixing.model.response.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    suspend fun getCountries(@Url url: String): Response<SearchResponse>?
}