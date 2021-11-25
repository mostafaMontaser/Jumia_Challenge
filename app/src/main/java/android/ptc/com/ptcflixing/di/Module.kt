package android.ptc.com.ptcflixing.di


import android.ptc.com.ptcflixing.dispatcher.search.SearchDispatcher
import android.ptc.com.ptcflixing.dispatcher.search.SearchDispatcherImpl
import android.ptc.com.ptcflixing.repository.local.BaseLocalRepo
import android.ptc.com.ptcflixing.repository.local.BaseLocalRepolmpl
import android.ptc.com.ptcflixing.repository.remote.search.SearchRemoteRepo
import android.ptc.com.ptcflixing.repository.remote.search.SearchRemoteRepoImpl
import android.ptc.com.ptcflixing.retrofit.Service
import android.ptc.com.ptcflixing.viewmodel.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module



val localRepoModule = module {
    single<BaseLocalRepo> { BaseLocalRepolmpl() }
}
val networkModule = module {
    single { Service.getService() }
}

val search = module {
    viewModel { SearchViewModel(get()) }
    single<SearchDispatcher> { SearchDispatcherImpl(get(), get()) }
    single<SearchRemoteRepo> { SearchRemoteRepoImpl(get()) }
}