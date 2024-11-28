package mx.com.cst.mobile.databaseexample.entity;

import android.content.ContentValues;

import java.io.Serializable;

import mx.com.cst.mobile.databaseexample.database.TaskDatabaseHelper;

public class TaskEntity implements Serializable {

    // Atributos de la entidad TaskEntity
    private int id;  // ID único de la tarea
    private String name;  // Nombre de la tarea
    private String details;  // Detalles o descripción de la tarea

    // Constructor vacío (sin parámetros)
    public TaskEntity() {
    }

    // Constructor con parámetros para inicializar los atributos
    public TaskEntity(int id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    // Getters y Setters para acceder y modificar los atributos de la tarea
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    // Méto_do toString() para representar la entidad como una cadena legible
    @Override
    public String toString() {
        return "Tarea{id=" + id + ", name='" + name + "', details='" + details + "'}";
    }

    // Méto_do toContentValues() para convertir la entidad en un objeto ContentValues
    public ContentValues toContentValues() {
        // Creamos un nuevo objeto ContentValues
        ContentValues values = new ContentValues();
        // Insertamos los valores de los atributos en el ContentValues
        values.put(TaskDatabaseHelper.COLUMN_NAME, this.name);
        values.put(TaskDatabaseHelper.COLUMN_DETAILS, this.details);
        // Retornamos el objeto ContentValues
        return values;
    }

}
