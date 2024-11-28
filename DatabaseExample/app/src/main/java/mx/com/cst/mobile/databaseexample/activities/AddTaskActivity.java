package mx.com.cst.mobile.databaseexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import mx.com.cst.mobile.databaseexample.R;
import mx.com.cst.mobile.databaseexample.database.TaskDatabaseHelper;
import mx.com.cst.mobile.databaseexample.entity.TaskEntity;

public class AddTaskActivity extends AppCompatActivity {

    // Declaración de los objetos que se utilizarán
    private EditText nameEditText;  // Campo de texto para ingresar el nombre de la tarea
    private EditText detailsEditText;  // Campo de texto para ingresar los detalles de la tarea
    private TaskDatabaseHelper dbHelper;  // Ayudante de base de datos para manejar la conexión

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);  // Establece el layout de la actividad

        // Inicialización de los campos EditText con sus IDs en el layout
        nameEditText = findViewById(R.id.nameEditText);
        detailsEditText = findViewById(R.id.detailsEditText);

        // Inicialización del objeto dbHelper, que manejará las operaciones de la base de datos
        dbHelper = new TaskDatabaseHelper(this);
    }

    // Método que se ejecuta cuando el usuario presiona el botón para guardar la tarea
    public void saveTask(View view) {
        // Obtiene los valores ingresados por el usuario en los campos de texto
        String name = nameEditText.getText().toString();
        String details = detailsEditText.getText().toString();

        // Verifica si alguno de los campos está vacío
        if (name.isEmpty() || details.isEmpty()) {
            // Si algún campo está vacío, muestra un mensaje de advertencia
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
        } else {
            // Si ambos campos están completos, crea una nueva entidad TaskEntity
            TaskEntity newTask = new TaskEntity(0, name, details);

            // Inserta la nueva tarea en la base de datos utilizando dbHelper
            dbHelper.getWritableDatabase().insert(
                    TaskDatabaseHelper.TABLE_TASKS, null, newTask.toContentValues());

            // Muestra un mensaje confirmando que la tarea fue agregada exitosamente
            Toast.makeText(this, "Task added!", Toast.LENGTH_SHORT).show();

            // Crea un Intent para devolver el resultado a la actividad principal
            Intent resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent);  // Establece el código de resultado como OK

            // Finaliza la actividad actual y vuelve a la actividad anterior
            finish();
        }
    }
}
