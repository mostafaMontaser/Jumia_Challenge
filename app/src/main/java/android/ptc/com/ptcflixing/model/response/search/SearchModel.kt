package android.ptc.com.ptcflixing.model.response.search

import com.google.gson.annotations.SerializedName

data class SearchModel(
    val name: String,
    val brand: String,
    @SerializedName("max_saving_percentage") val maxSavingPercentage: Int,
    val price: String,
    @SerializedName("special_price") val specialPrice: String,
    val image: String,
    @SerializedName("rating_average") val ratingAverage: Float?
)