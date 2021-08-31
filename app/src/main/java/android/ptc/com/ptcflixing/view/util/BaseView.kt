package android.ptc.com.ptcflixing.view.util

import android.ptc.com.ptcflixing.model.response.ErrorScreen

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun showError(error: ErrorScreen)
}