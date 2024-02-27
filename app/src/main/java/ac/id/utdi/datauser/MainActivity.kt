package ac.id.utdi.datauser

// pada bagian ini kita akan panggil data di MainActivity dengan menerapkan di recylerview menggunakan
// adapter yang telah kita buat 
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<PostResponse>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                val responseCode = response.code().toString()
                tvResponseCode.text = responseCode
                response.body()?.let { list.addAll(it)}
                val adapter = PostAdapter(list)
                rvPost.adapter = adapter
            }
        })
    }
}
