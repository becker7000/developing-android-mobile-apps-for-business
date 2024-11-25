package mx.ipn.cic.fragmentsnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import mx.ipn.cic.fragmentsnavigationexample.fragments.FirstFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            //Generar instancia del Fragmento
            val fragment1 = FirstFragment.newInstance()

            //Iniciar una transacción
            val fragmentTansaction = this.supportFragmentManager.beginTransaction()

            //Definir la transacción
            fragmentTansaction.add(
                R.id.fragmentContainer,
                fragment1
            )

            //Confirmar la transacción
            fragmentTansaction.commit()
        }

    }

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()
    }


}