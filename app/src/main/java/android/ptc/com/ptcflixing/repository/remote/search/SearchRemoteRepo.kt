package android.ptc.com.ptcflixing.repository.remote.search


import android.ptc.com.ptcflixing.model.request.BaseRequestFactory
import android.ptc.com.ptcflixing.model.response.search.SearchResponse
import android.ptc.com.ptcflixing.model.retrofit.Api
import android.ptc.com.ptcflixing.repository.remote.BaseRemoteRepo

import retrofit2.Response

class SearchRemoteRepo(var api: Api) : BaseRemoteRepo() {
    override suspend fun fetchData(requestFactory: BaseRequestFactory): Response<SearchResponse>? {
        return api.getCountries(requestFactory.getUrl())
    }
}