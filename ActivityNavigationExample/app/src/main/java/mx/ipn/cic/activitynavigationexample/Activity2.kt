package mx.ipn.cic.activitynavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.log

class Activity2 : AppCompatActivity() {

    lateinit var fabBack: FloatingActionButton
    lateinit var tvTexto: TextView
    lateinit var tvNumero: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        this.tvTexto = findViewById(R.id.tvTexto)
        this.tvNumero = findViewById(R.id.tvNumero)

        this.fabBack = findViewById(R.id.fabBack)
        this.fabBack.setOnClickListener {
            this.finish()
        }

        val cadena = this.intent.getStringExtra("argumentoString")
        val valorLong = this.intent.getLongExtra("argumentoLong", -1)
        val unBoolean = this.intent.getBooleanExtra("unBoolean", false)

        Log.d("MPS", "Valor String: $cadena")
        Log.d("MPS", "Valor Long: $valorLong")
        Log.d("MPS", "Valor Boolean: $unBoolean")

        tvTexto.text = cadena
        tvNumero.text = "$valorLong"


        val persona = intent
            .getSerializableExtra("persona") as UserDTO
        Log.d("MPS", persona.fullName)

        val prod1 = intent.getSerializableExtra("producto1") as ProductDTO
        Log.d("MPS", prod1.fullName())

        val prod2 = intent.getSerializableExtra("producto2") as ProductDTO
        Log.d("MPS", prod2.fullName())

    }

    override fun onBackPressed() {

        Log.d("MPS", "Evitando el back")

    }

}