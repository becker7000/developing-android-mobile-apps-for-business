package mx.com.cst.mobile.fragmentsnavigation.fragments;

// Importa las clases necesarias de Android para gestionar el ciclo de vida del fragmento y la interfaz gráfica
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

// Importa las clases de soporte para trabajar con fragmentos y otros componentes gráficos
import androidx.fragment.app.Fragment;

// Importa los componentes de Material Design para agregar un slider y un campo de texto con validación
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputLayout;

// Importa el archivo de recursos que contiene las definiciones del layout
import mx.com.cst.mobile.fragmentsnavigation.R;

public class FirstFragment extends Fragment {

    private Button btnNavega;  // Declaración del botón de navegación
    private TextInputLayout tilCampoTexto;  // Campo de texto con validación (InputLayout)
    private Slider sSlider;  // Control deslizante (slider) para seleccionar valores numéricos

    // Constructor vacío por defecto
    public FirstFragment() {
        super();
        // Configuración de la instancia si es necesario, por ejemplo, inicialización de variables
    }

    // Mét_odo que se llama cuando se crea la instancia del fragmento
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configura elementos lógicos del fragmento, como clientes de web services o conexiones a bases de datos
        // Ejemplo: Inicialización de ViewModel, llamada a servicios web, etc.

        if (getArguments() != null) {
            // Si el fragmento recibe argumentos, procesarlos aquí
        }
    }

    // Este mét_odo se llama para crear la interfaz gráfica del fragmento
    @Override
    public View onCreateView(
            LayoutInflater inflater, // Infla la vista para el fragment
            ViewGroup container, // La raíz del contenedor donde se mostrará el fragmento
            Bundle savedInstanceState
    ) {
        // Infla y devuelve el layout correspondiente a este fragmento
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    // Este mét_odo se llama cuando la vista del fragmento ya ha sido creada
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicialización de los elementos visuales del fragmento
        this.tilCampoTexto = view.findViewById(R.id.tilCampoTexto);  // Campo de texto (InputLayout)
        this.sSlider = view.findViewById(R.id.sSlider);  // Slider
        this.btnNavega = view.findViewById(R.id.btnNavega);  // Botón de navegación

        // Configura un listener para el evento de clic del botón de navegación
        this.btnNavega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica si el campo de texto no está vacío
                if (!tilCampoTexto.getEditText().getText().toString().isEmpty()) {

                    // Si el campo no está vacío, eliminamos cualquier mensaje de error
                    tilCampoTexto.setError(null);

                    // Crea una instancia del segundo fragmento y pasa los datos a través de los argumentos
                    SecondFragment fragment2 = SecondFragment.newInstance(
                            tilCampoTexto.getEditText().getText().toString(),
                            (int) sSlider.getValue()
                    );

                    // Inicia la transacción para cambiar al segundo fragmento
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, fragment2)  // Reemplaza el fragmento actual
                            .addToBackStack("firstFragment")  // Agrega la transacción a la pila de retroceso
                            .commit();  // Realiza la transacción
                } else {
                    // Si el campo de texto está vacío, muestra un mensaje de error
                    tilCampoTexto.setError("Debes capturar algo");
                }
            }
        });
    }

    // Se llama cuando el fragmento se vuelve visible y está listo para interactuar con el usuario
    @Override
    public void onStart() {
        super.onStart();
    }

    // Se llama cuando el fragmento vuelve a estar en primer plano después de estar en segundo plano
    @Override
    public void onResume() {
        super.onResume();

        // Aquí se pueden lanzar procesos como consultas a servicios web, bases de datos, o mostrar contenido multimedia
    }

    // Mét_odo de ejemplo sin implementación, solo para ilustrar
    public void myMethod() {
        // Implementación del méto_do
    }

    // Otro mét_odo de ejemplo, que toma parámetros y devuelve una cadena de texto
    public String myMethod2(String param1, int param2) {
        return "Param1= " + param1 + " Param2=" + param2;
    }

    // Mét_odo estático para crear una nueva instancia del fragmento
    public static FirstFragment newInstance() {
        return new FirstFragment();
    }
}
