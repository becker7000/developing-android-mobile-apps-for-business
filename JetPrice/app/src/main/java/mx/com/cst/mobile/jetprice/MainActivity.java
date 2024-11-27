package mx.com.cst.mobile.jetprice;

import androidx.appcompat.app.AppCompatActivity;  // Importa la clase base para actividades con soporte de la interfaz moderna
import android.os.Bundle;  // Importa Bundle para pasar datos entre actividades
import android.content.Intent;  // Importa Intent para iniciar nuevas actividades
import android.net.Uri;  // Importa Uri para trabajar con URLs
import android.view.View;  // Importa View para manejar eventos de las vistas
import android.widget.Button;  // Importa Button para manejar botones de la interfaz
import android.widget.ListView;  // Importa ListView si es necesario (no se usa aquí, pero podría ser útil para un menú o lista)

public class MainActivity extends AppCompatActivity {

    private ListView menuListView;  // Declara una ListView (aunque no es utilizada en el código)
    private Button btnCotizacion, btnGoogle, btnAcercaDe;  // Declara tres botones para navegar a diferentes pantallas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // Llama al método onCreate() de la clase base
        setContentView(R.layout.activity_main);  // Establece el layout de la actividad

        // Inicializa los botones a partir de sus ID en el layout
        btnCotizacion = findViewById(R.id.btnCotizacion);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnAcercaDe = findViewById(R.id.btnAcercaDe);

        // Manejar el clic en el botón de Cotización
        btnCotizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPantallaCotizacion();  // Llama a la función que abre la pantalla de cotización
            }
        });

        // Manejar el clic en el botón de Google
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirGoogle();  // Llama a la función que abre Google en el navegador
            }
        });

        // Manejar el clic en el botón de Acerca de...
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarAcercaDe();  // Llama a la función que abre la pantalla "Acerca de..."
            }
        });
    }

    // Método para abrir la pantalla de cotización (PriceActivity)
    private void abrirPantallaCotizacion() {
        Intent intent = new Intent(this, PriceActivity.class);  // Crea un Intent para abrir PriceActivity
        startActivity(intent);  // Inicia la actividad especificada en el Intent
    }

    // Método para abrir el navegador y cargar la página de Google
    private void abrirGoogle() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));  // Crea un Intent para abrir Google
        startActivity(intent);  // Inicia la actividad del navegador con el Intent
    }

    // Método para abrir la pantalla "Acerca de..." (AboutActivity)
    private void mostrarAcercaDe() {
        Intent intent = new Intent(this, AboutActivity.class);  // Crea un Intent para abrir AboutActivity
        startActivity(intent);  // Inicia la actividad especificada en el Intent
    }

}
