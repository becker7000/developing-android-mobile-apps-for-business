package mx.ipn.cic.fragmentsnavigationexample.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.ipn.cic.fragmentsnavigationexample.R

class SecondFragment : Fragment() {

    lateinit var fabAtras: FloatingActionButton
    lateinit var tvCadena: TextView
    lateinit var tvNumero: TextView

    lateinit var texto: String
    var numero: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.arguments?.let {
            this.texto = it.getString(CADENA_ARG, "")
            this.numero = it.getInt(ENTERO_ARG, -1)
        }
        /*if (this.arguments != null) {

            this.texto = this.requireArguments().getString("cadena", "")
            this.numero = this.requireArguments().getInt("entero", -1)

        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_second,
            container,
            false
        )
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        this.fabAtras = view.findViewById(R.id.fabBack)
        this.fabAtras.setOnClickListener {

            this.parentFragmentManager.popBackStack()

        }

        Log.d("MPS", "Texto: ${this.texto} Numero: ${this.numero}")

        this.tvCadena = view.findViewById(R.id.tvCadena)
        this.tvNumero = view.findViewById(R.id.tvNumero)

        this.tvCadena.text = "Cadena: ${this.texto}"
        this.tvNumero.text = "Numero: ${this.numero}"

    }

    companion object {

        private const val CADENA_ARG = "CADENA_ARG"
        private const val ENTERO_ARG = "ENTERO_ARG"

        @JvmStatic
        fun newInstance(cadena: String, entero: Int) = SecondFragment().apply {
            this.arguments = Bundle().apply {
                this.putString(CADENA_ARG, cadena)
                this.putInt(ENTERO_ARG, entero)
            }
        }

        /*@JvmStatic
        fun newInstance(cadena: String, entero: Int): SecondFragment {

            return SecondFragment().apply {
                this.arguments = Bundle().apply {
                    this.putString("cadena", cadena)
                    this.putInt("entero", entero)
                }
            }

            /*
            val fragment = SecondFragment()
            val argumentos = Bundle()
            argumentos.putString("cadena", cadena)
            argumentos.putInt("entero", entero)

            fragment.arguments = argumentos

            return fragment
            */
        }*/
    }
}