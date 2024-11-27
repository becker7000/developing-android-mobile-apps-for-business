package mx.com.cst.mobile.jetprice;

import android.content.Intent;  // Importa la clase Intent para iniciar nuevas actividades
import android.os.Bundle;  // Importa Bundle para pasar datos entre actividades
import android.view.View;  // Importa la clase View para manejar vistas y eventos
import android.widget.ImageButton;  // Importa la clase ImageButton para interactuar con un botón de imagen

import androidx.appcompat.app.AppCompatActivity;  // Importa la clase base para actividades con soporte de la interfaz moderna

public class AboutActivity extends AppCompatActivity {

    private ImageButton back;  // Declara un ImageButton para el botón de regresar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // Llama al método onCreate() de la clase base
        setContentView(R.layout.activity_about);  // Establece el layout de la actividad (activity_about)

        back = findViewById(R.id.back);  // Inicializa el ImageButton con el ID 'back' del layout

        // Establece un OnClickListener para el botón de regresar
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresarPantallaInicio();  // Llama a la función para regresar a la actividad principal
            }
        });
    }

    // Método para regresar a la actividad principal (MainActivity)
    private void regresarPantallaInicio() {
        Intent intent = new Intent(this, MainActivity.class);  // Crea un Intent para abrir la MainActivity
        startActivity(intent);  // Inicia la actividad especificada en el Intent
    }
}
