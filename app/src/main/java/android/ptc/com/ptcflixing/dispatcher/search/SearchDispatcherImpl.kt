package android.ptc.com.ptcflixing.dispatcher.search

import android.ptc.com.ptcflixing.repository.local.BaseLocalRepo
import android.ptc.com.ptcflixing.repository.remote.search.SearchRemoteRepo

class SearchDispatcherImpl(
    override val localRepo: BaseLocalRepo,
    override val remoteRepo: SearchRemoteRepo
) :
    SearchDispatcher

