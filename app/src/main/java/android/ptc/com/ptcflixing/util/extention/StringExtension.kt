package android.ptc.com.ptcflixing.util.extention

import android.ptc.com.ptcflixing.util.parsing.ParsingHelper
import java.lang.reflect.Type

fun <T> String.convertToModel(type: Type): T? {
    return ParsingHelper.gson?.fromJson<T>(this, type)}


