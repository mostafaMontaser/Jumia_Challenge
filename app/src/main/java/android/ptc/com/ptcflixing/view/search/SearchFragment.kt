package android.ptc.com.ptcflixing.view.search

import android.os.Bundle
import android.ptc.com.ptcflixing.databinding.FragmentSearchBinding
import android.ptc.com.ptcflixing.model.response.ErrorScreen
import android.ptc.com.ptcflixing.model.response.search.SearchModel
import android.ptc.com.ptcflixing.util.extention.gone
import android.ptc.com.ptcflixing.util.extention.show
import android.ptc.com.ptcflixing.util.network.NetworkUtil
import android.ptc.com.ptcflixing.view.BasicFragment
import android.ptc.com.ptcflixing.viewmodel.BaseViewModel
import android.ptc.com.ptcflixing.viewmodel.search.SearchViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.android.ext.android.inject

class SearchFragment : BasicFragment() {
    private val viewModel: SearchViewModel by inject()
    override fun getViewModel(): BaseViewModel = viewModel
    private lateinit var binding: FragmentSearchBinding
    private val searchAdapter = SearchAdapter(arrayListOf())

    override fun showLoading() {
        binding.loadingView.show()
    }

    override fun hideLoading() {
        binding.loadingView.gone()
    }

    override fun showError(error: ErrorScreen) {
        if (NetworkUtil.NO_INTERNET_CONNECTION_CODE == error.responseCode) {
            binding.layoutError.show()
        } else
            super.showError(error)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (!::binding.isInitialized) {
            binding = FragmentSearchBinding.inflate(inflater, container, false);
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun observeViewModel() {
        viewModel.searchResults.observe(this, {
            it?.let {
                binding.listSearch.show()
                @Suppress("UNCHECKED_CAST")
                val list = it as? List<SearchModel> ?: listOf()
                searchAdapter.updateData(list)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        viewModel.getSearchResults()
    }

    private fun initUI() {
        binding.listSearch.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = searchAdapter
        }
        binding.btnTryAgain.setOnClickListener {
            binding.layoutError.gone()
            viewModel.getSearchResults()
        }
    }
}