package android.ptc.com.ptcflixing.repository.local

import android.ptc.com.ptcflixing.model.response.CacheEntry
import android.ptc.com.ptcflixing.util.extention.convertToModel
import android.ptc.com.ptcflixing.util.parsing.ParsingHelper
import java.lang.reflect.Type
import java.util.*

open class BaseLocalRepo {
    open fun getCashedObject(type: Type): Any? {
        val entry: CacheEntry<Any>? = SecureSharedPref.getObject(type)
        val cachedObject: Any? = entry?.obj
        return if (cachedObject != null) {
            val cachedObject: Any? =
                ParsingHelper.gson?.toJson(cachedObject)?.convertToModel(type)
            cachedObject
        } else null
    }
    fun <T> saveObject(instance: T, type: Type, lastModifiedDate: Long = Date().time) =
        SecureSharedPref.edit().putObject(CacheEntry(instance, lastModifiedDate), type).apply()

}