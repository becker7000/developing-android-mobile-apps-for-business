package mx.com.cst.mobile.activitynavigation;

import android.content.Intent; // Para manejar la navegación entre actividades
import android.os.Bundle; // Para manejar el ciclo de vida de las actividades
import android.util.Log; // Para registrar mensajes en Logcat
import android.widget.Button; // Para trabajar con botones en la interfaz
import android.widget.EditText; // Para trabajar con campos de texto en la interfaz
import androidx.appcompat.app.AppCompatActivity; // Clase base para las actividades que usan el tema AppCompat

public class MainActivity extends AppCompatActivity {

    // Declaración de los elementos de la interfaz
    private Button btnNavega; // El botón que permite navegar a la siguiente actividad
    private EditText etCampoTexto; // El campo de texto para ingresar una cadena
    private EditText etCampoNumerico; // El campo de texto para ingresar un número

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llamada onCreate de la clase base
        setContentView(R.layout.activity_main); // Establece el diseño (layout) de la actividad

        // Inicializar las vistas (enlazar las vistas con las variables declaradas)
        this.etCampoTexto = findViewById(R.id.etCampoTexto); // Enlaza el campo de texto para cadenas
        this.etCampoNumerico = findViewById(R.id.etCampoNumerico); // Enlaza el campo de texto para números

        this.btnNavega = findViewById(R.id.btnNavega); // Enlaza el botón para navegar

        // Configuración del Listener para el botón
        this.btnNavega.setOnClickListener(v -> {
            Log.d("EAB", "Navegando a Activity 2"); // Registro en Logcat para indicar que estamos navegando a Activity2

            // Crear el Intent para navegar de la actividad actual a SecondActivity
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            // Pasar el valor del campo de texto como argumento al siguiente Activity
            intent.putExtra("argumentoString", etCampoTexto.getText().toString());

            // Convertir el texto a Long y pasarlo como argumento
            String numeroString = etCampoNumerico.getText().toString(); // Obtener el texto del campo numérico
            Long numeroLong = null;
            try {
                // Intentar convertir el texto a un número Long
                numeroLong = Long.parseLong(numeroString);
            } catch (NumberFormatException e) {
                // Manejar el caso donde el texto no es un número válido
                Log.d("MPS", "Número no válido: " + e.getMessage()); // Registrar el error en Logcat
            }

            // Pasar el número Long como argumento al Intent
            intent.putExtra("argumentoLong", numeroLong);

            // Pasar un valor booleano como argumento al Intent
            intent.putExtra("unBoolean", true);

            // Crear un objeto de tipo UserDTO (un DTO para representar una persona)
            UserDTO persona = new UserDTO("Carlos", "Santana", 45); // Nombre, apellido y edad
            intent.putExtra("persona", persona); // Pasar el objeto persona al siguiente Activity

            // Crear dos objetos de tipo ProductDTO (representan productos)
            ProductDTO producto1 = new ProductDTO("Producto1", 100.00, 20); // Nombre, precio y stock
            ProductDTO producto2 = new ProductDTO(); // Crear un producto vacío
            producto2.setProductName("Chocolates"); // Establecer el nombre del segundo producto

            // Pasar los objetos ProductDTO al Intent
            intent.putExtra("producto1", producto1); // Pasar el primer producto
            intent.putExtra("producto2", producto2); // Pasar el segundo producto

            // Iniciar la segunda actividad (SecondActivity)
            startActivity(intent);

            // Para evitar que el usuario regrese a MainActivity, puedes terminarla
            // finish(); // Si deseas cerrar la actividad actual después de navegar
        });
    }
}
