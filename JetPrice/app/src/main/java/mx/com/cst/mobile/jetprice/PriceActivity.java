package mx.com.cst.mobile.jetprice;

import androidx.appcompat.app.AppCompatActivity;  // Clase base para actividades con soporte de la interfaz moderna
import android.os.Bundle;  // Para manejar el ciclo de vida de la actividad
import android.view.View;  // Para manejar las vistas de la interfaz
import android.widget.AdapterView;  // Para escuchar los eventos de selección en un Spinner
import android.widget.ArrayAdapter;  // Para crear un adaptador para los elementos del Spinner
import android.widget.Button;  // Para trabajar con botones
import android.widget.EditText;  // Para trabajar con campos de texto
import android.widget.RadioButton;  // Para manejar botones de opción
import android.widget.Spinner;  // Para usar Spinner (menú desplegable)
import android.widget.TextView;  // Para mostrar texto en la interfaz
import android.widget.Toast;  // Para mostrar mensajes cortos en la pantalla

public class PriceActivity extends AppCompatActivity {

    // Declaración de las vistas y variables necesarias
    private EditText nombreEditText, kilometrosEditText, pasajerosEditText;
    private Spinner temporadaSpinner;
    private RadioButton socioRadioButton, estudianteRadioButton;
    private Button cotizarButton;
    private TextView resultadoTextView;
    private double tarifa;

    // Definir las tarifas para las diferentes temporadas
    private final double TARIFA1 = 0.8;
    private final double TARIFA2 = 1.05;
    private final double TARIFA3 = 1.45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // Llamada al método onCreate() de la clase base
        setContentView(R.layout.activity_price);  // Establece el layout de la actividad

        // Inicializa las vistas a partir de los IDs definidos en el layout
        nombreEditText = findViewById(R.id.nombreEditText);
        kilometrosEditText = findViewById(R.id.kilometrosEditText);
        pasajerosEditText = findViewById(R.id.pasajerosEditText);
        temporadaSpinner = findViewById(R.id.temporadaSpinner);
        socioRadioButton = findViewById(R.id.socioRadioButton);
        estudianteRadioButton = findViewById(R.id.estudianteRadioButton);
        cotizarButton = findViewById(R.id.cotizarButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        // Crear un adaptador para el Spinner de temporadas
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones_temporada, android.R.layout.simple_spinner_item);

        // Especificar el diseño del dropdown (lista desplegable) para el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador al Spinner para que muestre las opciones
        temporadaSpinner.setAdapter(adapter);

        // Listener para cuando se selecciona una opción en el Spinner
        temporadaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Se ejecuta cuando se selecciona una temporada del Spinner
                String temporadaSeleccionada = parentView.getItemAtPosition(position).toString();

                // Llama a la función para obtener la tarifa según la temporada seleccionada
                tarifa = obtenerTarifaPorTemporada(temporadaSeleccionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Se ejecuta cuando no se selecciona ninguna opción
                Toast.makeText(PriceActivity.this, "Selecciona una temporada", Toast.LENGTH_SHORT).show();
            }
        });

        // Listener para el botón de "Cotizar"
        cotizarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene los valores de los campos de texto, Spinner y RadioButtons
                String nombre = nombreEditText.getText().toString();
                double kilometros = Double.parseDouble(kilometrosEditText.getText().toString());
                int pasajeros = Integer.parseInt(pasajerosEditText.getText().toString());
                String temporada = temporadaSpinner.getSelectedItem().toString();

                // Calcula el precio neto multiplicando los kilómetros, tarifa y pasajeros
                double precioNeto = kilometros * tarifa * pasajeros;

                // Calcula los descuentos según si es socio o estudiante
                double descuentoMembresia = socioRadioButton.isChecked() ? 0.25 * precioNeto : 0;
                double descuentoEstudiante = estudianteRadioButton.isChecked() ? 0.1 * precioNeto : 0;

                // Calcula el total a pagar después de aplicar los descuentos
                double totalAPagar = precioNeto - descuentoMembresia - descuentoEstudiante;

                // Prepara el resultado como un texto para mostrarlo
                String resultado = "\n" +
                        "Cliente: " + nombre + "\n" +
                        "Kilómetros: " + kilometros + "\n" +
                        "Pasajeros: " + pasajeros + "\n" +
                        "Temporada: " + temporada + "\n" +
                        "Descuento Membresía: " + descuentoMembresia + "\n" +
                        "Descuento Estudiante: " + descuentoEstudiante + "\n" +
                        "Total a Pagar: " + totalAPagar;

                // Muestra el resultado en el TextView
                resultadoTextView.setText(resultado);

                // Muestra un mensaje emergente (Toast) notificando que la cotización se calculó
                Toast.makeText(PriceActivity.this, "Cotización calculada", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Función para obtener la tarifa según la temporada seleccionada
    private double obtenerTarifaPorTemporada(String temporada) {
        double tarifa = 0.0;  // Valor predeterminado o tarifa base
        switch (temporada) {
            case "Febrero-Marzo":
                tarifa = TARIFA1;  // Asigna tarifa para la temporada de febrero-marzo
                break;
            case "Mayo-Junio":
                tarifa = TARIFA2;  // Asigna tarifa para la temporada de mayo-junio
                break;
            case "Septiembre-Octubre":
                tarifa = TARIFA3;  // Asigna tarifa para la temporada de septiembre-octubre
                break;
            // Agrega más casos si es necesario
            default:
                // Si no coincide con ninguna de las temporadas conocidas, mantiene tarifa base
                break;
        }
        return tarifa;  // Devuelve la tarifa correspondiente
    }
}
