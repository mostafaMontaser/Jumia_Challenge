package android.ptc.com.ptcflixing.model.response


data class ResponseException(
    override var message: String? = "",
    var responseCode: String? = "",
    var endPoint: String? = ""
) : Exception()