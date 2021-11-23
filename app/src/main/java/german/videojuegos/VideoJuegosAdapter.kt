package german.videojuegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VideoJuegosAdapter(private val videojuegoList: ArrayList<VideoJuegoItem>) : RecyclerView.Adapter<VideoJuegosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_video_juego,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videojuego = videojuegoList[position]
        holder.bind(videojuego)
    }

    override fun getItemCount(): Int {
        return  videojuegoList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private var nameTextView : TextView = view.findViewById(R.id.videojuego_para_card_view)
        private var scoreTextView : TextView = view.findViewById(R.id.puntuacion_para_card_view)
        private var descriptionTextView : TextView = view.findViewById(R.id.descripcion_para_card_view)
        private var pictureImageView : ImageView = view.findViewById(R.id.imagen_para_card_view)

        fun bind(videojuego : VideoJuegoItem){
            nameTextView.text = videojuego.name
            scoreTextView.text = videojuego.score.toString()
            descriptionTextView.text = videojuego.description
            Picasso.get().load(videojuego.urlPicture).into(pictureImageView)
        }
    }
}