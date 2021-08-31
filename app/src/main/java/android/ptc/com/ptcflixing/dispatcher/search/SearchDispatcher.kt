package android.ptc.com.ptcflixing.dispatcher.search

import android.ptc.com.ptcflixing.dispatcher.BaseDispatcher
import android.ptc.com.ptcflixing.repository.local.BaseLocalRepo
import android.ptc.com.ptcflixing.repository.remote.search.SearchRemoteRepo

class SearchDispatcher(localRepo: BaseLocalRepo, remoteRepo: SearchRemoteRepo) :
    BaseDispatcher(localRepo, remoteRepo)