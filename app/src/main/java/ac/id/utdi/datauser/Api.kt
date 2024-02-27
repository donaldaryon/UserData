package ac.id.utdi.datauser

// membuat interface untuk API dengan menggunakan method GET untuk mengambil data jason dari web placeholder.typecode.com yang 
// akan digunakan dalam aplikasi ini  dengan fungsi getPosts
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<ArrayList<PostResponse>>
}
