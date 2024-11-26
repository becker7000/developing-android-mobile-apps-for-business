package mx.com.cst.mobile.fragmentsnavigation.fragments;

// Importa las clases necesarias de Android para gestionar el ciclo de vida del fragmento y las vistas
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Importa la clase Fragment de Android para usar la funcionalidad de fragmentos
import androidx.fragment.app.Fragment;

// Importa los elementos de Material Design, en este caso un FloatingActionButton para el botón flotante
import com.google.android.material.floatingactionbutton.FloatingActionButton;

// Importa el archivo de recursos que contiene las definiciones del layout
import mx.com.cst.mobile.fragmentsnavigation.R;


public class SecondFragment extends Fragment {

    private FloatingActionButton fabAtras;  // Declaración del botón flotante para regresar al fragment anterior
    private TextView tvCadena;  // Declaración de un TextView para mostrar el texto (cadena)
    private TextView tvNumero;  // Declaración de un TextView para mostrar el número

    private String texto;  // Variable para almacenar la cadena que se recibe como argumento
    private int numero;  // Variable para almacenar el número que se recibe como argumento

    // Mét_odo llamado cuando se crea el fragmento, se usa para configurar los argumentos si existen
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verifica si el fragmento recibe argumentos y los almacena en las variables correspondientes
        if (getArguments() != null) {
            this.texto = getArguments().getString(CADENA_ARG, "");  // Obtiene la cadena pasada
            this.numero = getArguments().getInt(ENTERO_ARG, -1);  // Obtiene el número pasado
        }
    }

    // Mét_odo llamado para inflar la vista (crear la interfaz del fragmento)
    @Override
    public View onCreateView(
            LayoutInflater inflater, // Infla la vista para el fragmento
            ViewGroup container, // Contenedor donde se colocará el fragmento
            Bundle savedInstanceState
    ) {
        // Infla y devuelve el layout correspondiente al fragmento
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    // Mét_odo que se llama una vez que la vista del fragmento ha sido creada
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa los componentes de la interfaz de usuario del fragmento
        this.fabAtras = view.findViewById(R.id.fabBack);  // Inicializa el botón flotante
        this.fabAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al hacer clic en el botón flotante, regresa al fragmento anterior
                getParentFragmentManager().popBackStack();
            }
        });

        // Registra en el Logcat los valores recibidos para la cadena y el número
        Log.d("MPS", "Texto: " + this.texto + " Numero: " + this.numero);

        // Inicializa los TextViews para mostrar los datos de texto y número
        this.tvCadena = view.findViewById(R.id.tvCadena);
        this.tvNumero = view.findViewById(R.id.tvNumero);

        // Establece el texto de los TextViews con los valores recibidos como argumentos
        this.tvCadena.setText("Cadena: " + this.texto);
        this.tvNumero.setText("Numero: " + this.numero);
    }

    // Constantes que se utilizan para pasar los argumentos al fragmento
    public static final String CADENA_ARG = "CADENA_ARG";
    public static final String ENTERO_ARG = "ENTERO_ARG";

    // Mét_odo estático que crea una nueva instancia del fragmento y pasa los argumentos necesarios
    public static SecondFragment newInstance(String cadena, int entero) {
        // Crea una nueva instancia del fragmento
        SecondFragment fragment = new SecondFragment();

        // Crea un Bundle para pasar los argumentos
        Bundle args = new Bundle();
        args.putString(CADENA_ARG, cadena);  // Pasa la cadena como argumento
        args.putInt(ENTERO_ARG, entero);  // Pasa el número como argumento

        // Asigna los argumentos al fragmento
        fragment.setArguments(args);

        // Retorna la nueva instancia del fragmento con los argumentos
        return fragment;
    }
}
