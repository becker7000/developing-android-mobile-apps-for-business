package mx.com.cst.mobile.fragmentsnavigation;

// Importa las clases necesarias de Android para gestionar las actividades y transacciones de fragmentos
import android.os.Bundle;

// Importa la clase AppCompatActivity para gestionar el ciclo de vida de la actividad
import androidx.appcompat.app.AppCompatActivity;

// Importa la clase FragmentTransaction para gestionar las transacciones de fragmentos
import androidx.fragment.app.FragmentTransaction;

// Importa el fragmento que se va a mostrar en la actividad
import mx.com.cst.mobile.fragmentsnavigation.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {

    // Mét_odo llamado cuando la actividad se crea
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Establece el layout XML para la actividad
        setContentView(R.layout.activity_main);

        // Verifica si la actividad no fue recreada (si no es un reinicio por cambio de configuración)
        if (savedInstanceState == null) {
            // Si es la primera vez que se crea, genera una nueva instancia del fragmento FirstFragment
            FirstFragment fragment1 = FirstFragment.newInstance();

            // Inicia una transacción para gestionar la adición del fragmento a la actividad
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            // Añade el fragmento al contenedor de fragmentos en el layout de la actividad
            fragmentTransaction.add(R.id.fragmentContainer, fragment1);

            // Confirma la transacción, realizando el cambio en la interfaz de usuario
            fragmentTransaction.commit();
        }
    }

    // Mét_odo llamado cuando la actividad pasa al estado de "start"
    @Override
    protected void onStart() {
        super.onStart();
    }

    // Mét_odo llamado cuando la actividad pasa al estado de "resume"
    @Override
    protected void onResume() {
        super.onResume();
    }
}
