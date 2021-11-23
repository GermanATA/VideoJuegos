package german.videojuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import german.videojuegos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        var VJ: VideoJuegoItem = intent.extras?.getSerializable("videojuego") as VideoJuegoItem

        with(mainBinding) {
            juegoTextView.text = VJ.name
            analisisTextView.text = VJ.description
            Picasso.get().load(VJ.urlPicture).into(juegoImageView)
        }



    }
}