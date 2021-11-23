package german.videojuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListVideoJuegosActivity : AppCompatActivity() {

    private lateinit var listaVideoJuegos : ArrayList<VideoJuegoItem>
    private lateinit var videojuegosAdapter : VideoJuegosAdapter
    private lateinit var videojuegosRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_video_juegos)

        videojuegosRecyclerView = findViewById(R.id.videojuegos_recycler_view)

        listaVideoJuegos = loadMockVideoJuegosFromJson()

        videojuegosAdapter = VideoJuegosAdapter(listaVideoJuegos)

        videojuegosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = videojuegosAdapter
            setHasFixedSize(false)
        }
    }

    private fun loadMockVideoJuegosFromJson():ArrayList<VideoJuegoItem>{
        val videojuegosString : String = applicationContext.assets.open("videojuegos.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(videojuegosString,VideoJuego :: class.java)
        return data
    }
}