package ac.id.utdi.datauser

pada bagian ini, saya membuat file PostResponse.kt untuk merespon data array untuk menampung data class postresponse setiap objek yang di ambil dari Api
import com.google.gson.annotations.SerializedName

data class PostResponse(
    val id: Int,
    val title: String?,
    @SerializedName("body")
    val text: String?
)
