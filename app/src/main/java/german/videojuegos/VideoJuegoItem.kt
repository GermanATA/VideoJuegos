package german.videojuegos


import com.google.gson.annotations.SerializedName

data class VideoJuegoItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Double,
    @SerializedName("urlPicture")
    val urlPicture: String
)