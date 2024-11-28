package mx.com.cst.mobile.databaseexample.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.List;

import mx.com.cst.mobile.databaseexample.R;
import mx.com.cst.mobile.databaseexample.database.TaskDatabaseHelper;
import mx.com.cst.mobile.databaseexample.entity.TaskEntity;

public class TaskAdapter extends BaseAdapter {

    private Context context;  // Contexto de la actividad o fragmento
    private List<TaskEntity> tasksList;  // Lista de tareas a mostrar
    private TaskDatabaseHelper dbHelper;  // Ayudante de base de datos para operaciones CRUD

    // Constructor que recibe el contexto, la lista de tareas y el ayudante de base de datos
    public TaskAdapter(Context context, List<TaskEntity> tasksList, TaskDatabaseHelper dbHelper) {
        this.context = context;
        this.tasksList = tasksList;
        this.dbHelper = dbHelper;
    }

    @Override
    public int getCount() {
        // Retorna la cantidad de elementos en la lista de tareas
        return tasksList.size();
    }

    @Override
    public Object getItem(int position) {
        // Retorna el objeto TaskEntity en la posición dada
        return tasksList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // Retorna el ID de la tarea en la posición dada
        return tasksList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflar la vista si es necesario (si convertView es null)
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_task, parent, false);  // Infla el layout de un item de tarea
        }

        // Obtener la tarea correspondiente a la posición
        TaskEntity task = tasksList.get(position);

        // Referencias a los elementos visuales del layout (Ícono, nombre, detalles)
        ImageView taskIcon = convertView.findViewById(R.id.taskIcon);
        TextView taskName = convertView.findViewById(R.id.taskName);
        TextView taskDetails = convertView.findViewById(R.id.taskDetails);

        // Establecer el ícono (se asume que tienes un ícono de tarea en los recursos de drawable)
        taskIcon.setImageResource(R.drawable.task);  // Asegúrate de tener este ícono en `res/drawable`

        // Establecer el nombre y los detalles de la tarea
        taskName.setText(task.getName());
        taskDetails.setText(task.getDetails());

        // Manejar el largo toque (long click) para eliminar la tarea
        convertView.setOnLongClickListener(v -> {
            // Mostrar un cuadro de diálogo de confirmación para eliminar la tarea
            new AlertDialog.Builder(context)
                    .setTitle("Eliminar Tarea")  // Título del diálogo
                    .setMessage("¿Estás seguro de que quieres eliminar esta tarea?")  // Mensaje de confirmación
                    .setPositiveButton("Sí", (dialog, which) -> {
                        // Eliminar la tarea de la base de datos
                        deleteTask(task.getId());
                        tasksList.remove(position);  // Eliminar la tarea de la lista
                        notifyDataSetChanged();  // Notificar al adaptador que los datos han cambiado
                        Toast.makeText(context, "Tarea eliminada", Toast.LENGTH_SHORT).show();  // Mostrar mensaje de éxito
                    })
                    .setNegativeButton("No", null)  // Botón de cancelar
                    .show();  // Mostrar el diálogo
            return true;  // Indicar que el evento ha sido manejado
        });

        return convertView;  // Retorna la vista del ítem
    }

    // Méto_do para eliminar una tarea de la base de datos
    private void deleteTask(int taskId) {
        // Obtener una instancia de la base de datos en modo escritura
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Eliminar la tarea de la base de datos usando su ID
        db.delete(TaskDatabaseHelper.TABLE_TASKS, TaskDatabaseHelper.COLUMN_ID + " = ?", new String[]{String.valueOf(taskId)});
    }
}
