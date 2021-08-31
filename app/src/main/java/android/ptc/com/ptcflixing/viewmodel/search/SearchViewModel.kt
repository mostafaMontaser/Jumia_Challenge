package android.ptc.com.ptcflixing.viewmodel.search

import android.ptc.com.ptcflixing.dispatcher.BaseDispatcher
import android.ptc.com.ptcflixing.dispatcher.search.SearchDispatcher
import android.ptc.com.ptcflixing.model.request.search.SearchRequestFactory
import android.ptc.com.ptcflixing.model.response.search.SearchResponse
import android.ptc.com.ptcflixing.viewmodel.BaseViewModel
import androidx.lifecycle.MutableLiveData

class SearchViewModel(private val searchDispatcher: SearchDispatcher) : BaseViewModel() {
    override fun getDispatcher(): BaseDispatcher = searchDispatcher
    val searchResults = MutableLiveData<List<*>>()
    fun getSearchResults() {
        fetchData(
            true,
            SearchResponse::class.java,
            SearchRequestFactory(),
            handleCountriesResponse
        )

    }

    private val handleCountriesResponse = { response: Any? ->
        if (response is SearchResponse) {
            searchResults.value = response.metadata.results
        }
    }
}