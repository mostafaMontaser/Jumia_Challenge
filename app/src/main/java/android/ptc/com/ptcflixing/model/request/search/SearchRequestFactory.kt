package android.ptc.com.ptcflixing.model.request.search

import android.ptc.com.ptcflixing.model.request.BaseRequestFactory
import android.ptc.com.ptcflixing.model.request.BaseRequestParam
import android.ptc.com.ptcflixing.model.retrofit.EndPoints

class SearchRequestFactory :
    BaseRequestFactory() {
    override fun getEndPoint(): String = EndPoints.SEARCH
    override fun getRequestParam(): BaseRequestParam = BaseRequestParam()
}