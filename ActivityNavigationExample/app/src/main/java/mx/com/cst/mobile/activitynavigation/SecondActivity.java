package mx.com.cst.mobile.activitynavigation;

import android.os.Bundle; // Para manejar el ciclo de vida de la actividad
import android.util.Log; // Para registrar mensajes en Logcat
import android.widget.TextView; // Para trabajar con TextViews en la interfaz
import com.google.android.material.floatingactionbutton.FloatingActionButton; // Para trabajar con botones flotantes
import androidx.appcompat.app.AppCompatActivity; // Clase base para las actividades que usan el tema AppCompat

public class SecondActivity extends AppCompatActivity {

    // Declaración de las vistas (elementos de la interfaz)
    private FloatingActionButton fabBack; // Botón flotante para regresar
    private TextView tvTexto; // TextView para mostrar texto
    private TextView tvNumero; // TextView para mostrar un número

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llamada al método onCreate de la clase base
        setContentView(R.layout.second_activity); // Establece el diseño (layout) de la actividad

        // Inicialización de vistas (enlazar las vistas con las variables declaradas)
        tvTexto = findViewById(R.id.tvTexto); // Enlaza el TextView para mostrar el texto
        tvNumero = findViewById(R.id.tvNumero); // Enlaza el TextView para mostrar el número

        fabBack = findViewById(R.id.fabBack); // Enlaza el botón flotante para regresar a la actividad anterior
        fabBack.setOnClickListener(v -> finish()); // Al hacer clic en el FAB, se finaliza esta actividad y se regresa a la anterior

        // Obtener los datos enviados desde la primera Activity
        // Recupera el valor del campo de texto (String)
        String cadena = getIntent().getStringExtra("argumentoString");
        // Recupera el valor numérico (Long)
        long valorLong = getIntent().getLongExtra("argumentoLong", -1); // Valor por defecto: -1
        // Recupera el valor booleano
        boolean unBoolean = getIntent().getBooleanExtra("unBoolean", false); // Valor por defecto: false

        // Mostrar en el log los valores recibidos para depuración
        Log.d("EAB", "Valor String: " + cadena); // Muestra el valor del String en Logcat
        Log.d("EAB", "Valor Long: " + valorLong); // Muestra el valor del Long en Logcat
        Log.d("EAB", "Valor Boolean: " + unBoolean); // Muestra el valor del Boolean en Logcat

        // Establecer los valores obtenidos en los TextViews
        tvTexto.setText(cadena); // Muestra el valor String en el TextView correspondiente
        tvNumero.setText(String.valueOf(valorLong)); // Muestra el valor Long convertido a String en el TextView correspondiente

        // Obtener objetos serializados enviados desde la primera actividad
        // Recupera el objeto UserDTO (que fue serializado en la primera actividad)
        UserDTO persona = (UserDTO) getIntent().getSerializableExtra("persona");
        if (persona != null) {
            Log.d("EAB", persona.getFullName()); // Si el objeto no es nulo, muestra el nombre completo de la persona en el Log
        }

        // Recupera el primer objeto ProductDTO (que fue serializado en la primera actividad)
        ProductDTO prod1 = (ProductDTO) getIntent().getSerializableExtra("producto1");
        if (prod1 != null) {
            Log.d("EAB", prod1.fullName()); // Si el objeto no es nulo, muestra el nombre completo del producto en el Log
        }

        // Recupera el segundo objeto ProductDTO (que fue serializado en la primera actividad)
        ProductDTO prod2 = (ProductDTO) getIntent().getSerializableExtra("producto2");
        if (prod2 != null) {
            Log.d("EAB", prod2.fullName()); // Si el objeto no es nulo, muestra el nombre completo del producto en el Log
        }
    }
}
