package mx.com.cst.mobile.databaseexample.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import mx.com.cst.mobile.databaseexample.R;
import mx.com.cst.mobile.databaseexample.adapters.TaskAdapter;
import mx.com.cst.mobile.databaseexample.database.TaskDatabaseHelper;
import mx.com.cst.mobile.databaseexample.entity.TaskEntity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;  // Lista para mostrar las tareas
    private TaskDatabaseHelper dbHelper;  // Ayudante de base de datos para manejar operaciones
    private ArrayList<TaskEntity> tasksList;  // Lista que almacenará las tareas obtenidas de la base de datos

    // Declaración del ActivityResultLauncher para gestionar el resultado de la actividad de agregar tarea
    private ActivityResultLauncher<Intent> addTaskLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Establece el layout de la actividad

        // Inicializa los componentes
        listView = findViewById(R.id.listView);  // Obtiene la referencia al ListView
        dbHelper = new TaskDatabaseHelper(this);  // Crea un objeto dbHelper para acceder a la base de datos

        tasksList = new ArrayList<>();  // Inicializa la lista que almacenará las tareas
        loadTasksFromDatabase();  // Carga las tareas desde la base de datos

        // Crea un adaptador personalizado para el ListView
        TaskAdapter adapter = new TaskAdapter(this, tasksList, dbHelper);
        listView.setAdapter(adapter);  // Asocia el adaptador al ListView

        // Inicializa el ActivityResultLauncher para manejar el resultado de la actividad AddTaskActivity
        addTaskLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {  // Si el resultado es OK
                tasksList.clear();  // Limpia la lista de tareas actual
                loadTasksFromDatabase();  // Vuelve a cargar las tareas desde la base de datos
                ((TaskAdapter) listView.getAdapter()).notifyDataSetChanged();  // Notifica al adaptador que los datos cambiaron
            }
        });

        // Configura el listener para cuando un ítem de la lista sea clickeado
        listView.setOnItemClickListener((parent, view, position, id) -> {
            TaskEntity task = tasksList.get(position);  // Obtiene la tarea seleccionada
            Toast.makeText(MainActivity.this, task.getName(), Toast.LENGTH_SHORT).show();  // Muestra el nombre de la tarea
        });
    }

    // Méto_do para cargar las tareas desde la base de datos
    private void loadTasksFromDatabase() {
        // Realiza una consulta a la base de datos para obtener todas las tareas
        Cursor cursor = dbHelper.getReadableDatabase().query(
                TaskDatabaseHelper.TABLE_TASKS,  // Nombre de la tabla
                new String[]{TaskDatabaseHelper.COLUMN_ID, TaskDatabaseHelper.COLUMN_NAME, TaskDatabaseHelper.COLUMN_DETAILS},  // Columnas a obtener
                null, null, null, null, null);  // Sin filtros ni orden específico

        // Itera sobre los resultados de la consulta y agrega cada tarea a la lista
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(TaskDatabaseHelper.COLUMN_ID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(TaskDatabaseHelper.COLUMN_NAME));
            @SuppressLint("Range") String details = cursor.getString(cursor.getColumnIndex(TaskDatabaseHelper.COLUMN_DETAILS));
            tasksList.add(new TaskEntity(id, name, details));  // Agrega la tarea a la lista
        }
        cursor.close();  // Cierra el cursor después de usarlo
    }

    // Méto_do que se ejecuta cuando el usuario quiere agregar una nueva tarea
    public void addTask(View view) {
        // Crea un Intent para iniciar la actividad AddTaskActivity
        Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
        addTaskLauncher.launch(intent);  // Lanza la actividad para agregar una tarea y espera el resultado
    }
}
