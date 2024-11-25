package mx.ipn.cic.activitynavigationexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var btnNavega: Button
    lateinit var etCampoTexto: EditText
    lateinit var etCampoNumerico: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etCampoTexto = findViewById(R.id.etCampoTexto)
        this.etCampoNumerico = findViewById(R.id.etCampoNumerico)

        this.btnNavega = findViewById(R.id.btnNavega)
        this.btnNavega.setOnClickListener {

            Log.d("MPS", "Navegando a Activity 2")

            val intent = Intent(this, Activity2::class.java)

            intent.putExtra("argumentoString", this.etCampoTexto.text.toString())

            val numeroString = this.etCampoNumerico.text.toString()
            val numeroLong: Long? = numeroString.toLongOrNull()

            intent.putExtra("argumentoLong", numeroLong)

            intent.putExtra("unBoolean", true)

            val persona = UserDTO("Manuel", "Pérez", 33)

            intent.putExtra("persona", persona)

            val producto1 = ProductDTO(
                "Producto1",
                100.00,
                20
            )

            val producto2 = ProductDTO()
            producto2.productName = "Chocolates"

            intent.putExtra("producto1", producto1)
            intent.putExtra("producto2", producto2)

            this.startActivity(intent)

            //Para evitar pasar por el MainActivity (primer pantalla)
            //this.finish()

        }

    }
}