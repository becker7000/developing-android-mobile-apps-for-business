package mx.ipn.cic.fragmentsnavigationexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.slider.Slider
import com.google.android.material.textfield.TextInputLayout
import mx.ipn.cic.fragmentsnavigationexample.R

class FirstFragment : Fragment() {

    lateinit var btnNavega: Button
    lateinit var tilCampoTexto: TextInputLayout
    lateinit var sSlider: Slider

    /*FirstFragment(){
        super()
        //configuramos la instancia
    }*/

    //Se crea la instancia del fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Ya tenemos Instancia del Fragment
        //Configurar los elementos Lógicos del fragment
        //Inicializar Cliente de WS
        //Inicializar Conector de BD
        //ViewModel

        arguments?.let {

        }
    }

    //Se crea la Interfaz gráfica del Fragment
    override fun onCreateView(
        inflater: LayoutInflater, //Infla la vista
        container: ViewGroup?, // La raiz del contenedor
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_first,
            container,
            false
        )
    }

    //Notifica que la Interfaz ya se creó
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        //Ya tenemos UI
        //Configurar los elementos visuales del fragment

        this.tilCampoTexto = view.findViewById(R.id.tilCampoTexto)
        this.sSlider = view.findViewById(R.id.sSlider)

        this.btnNavega = view.findViewById(R.id.btnNavega)
        this.btnNavega.setOnClickListener {

            if (this.tilCampoTexto.editText!!.text.isNotEmpty()) {

                this.tilCampoTexto.error = null

                //Poner fragmento 2
                val fragment2 = SecondFragment.newInstance(
                    this.tilCampoTexto.editText?.text.toString(),
                    this.sSlider.value.toInt()
                )

                val transaction = this.parentFragmentManager.beginTransaction()
                transaction.replace(
                    R.id.fragmentContainer,
                    fragment2
                )
                transaction.addToBackStack("firstFragment")
                transaction.commit()

            } else {
                this.tilCampoTexto.error = "Debes capturar algo"
            }
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        //Lanzar procesos
        //Consumir un WS
        //Consultar BD
        //Mostrar un video
    }

    fun myMethod() {

    }

    fun myMethod2(param1: String, param2: Int): String {
        return "Param1= $param1 Param2=$param2"
    }

    //Para métodos o propiedades "estáticos"
    companion object {

        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}