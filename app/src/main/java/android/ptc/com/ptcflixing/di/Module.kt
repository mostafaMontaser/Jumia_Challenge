package android.ptc.com.ptcflixing.di


import android.ptc.com.ptcflixing.dispatcher.search.SearchDispatcher
import android.ptc.com.ptcflixing.repository.local.BaseLocalRepo
import android.ptc.com.ptcflixing.repository.remote.search.SearchRemoteRepo
import android.ptc.com.ptcflixing.retrofit.Service
import android.ptc.com.ptcflixing.viewmodel.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module



val localRepoModule = module {
    single { BaseLocalRepo() }
}
val networkModule = module {
    single { Service.getService() }
}

val search = module {
    viewModel { SearchViewModel(get()) }
    single { SearchDispatcher(get(), get()) }
    single { SearchRemoteRepo(get()) }
}