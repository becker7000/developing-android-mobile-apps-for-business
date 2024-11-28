package mx.com.cst.mobile.databaseexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDatabaseHelper extends SQLiteOpenHelper {

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "todolist.db";
    // Versión de la base de datos (si se cambia la versión, es necesario gestionar la migración)
    private static final int DATABASE_VERSION = 1;

    // Nombre de la tabla y de las columnas
    public static final String TABLE_TASKS = "tasks";  // Nombre de la tabla
    public static final String COLUMN_ID = "id";  // Nombre de la columna para el ID
    public static final String COLUMN_NAME = "name";  // Nombre de la columna para el nombre de la tarea
    public static final String COLUMN_DETAILS = "details";  // Nombre de la columna para los detalles de la tarea

    // Instrucción SQL para crear la tabla de tareas
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_TASKS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_DETAILS + " TEXT);";  // Definimos la estructura de la tabla

    // Constructor de la clase, recibe el contexto de la aplicación
    public TaskDatabaseHelper(Context context) {
        // Llama al constructor de SQLiteOpenHelper con el contexto, el nombre de la base de datos y la versión
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Este méto_do se llama la primera vez que la base de datos es creada
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Ejecuta el SQL para crear la tabla
        db.execSQL(TABLE_CREATE);
    }

    // Este méto_do se llama cuando se actualiza la versión de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Si la base de datos ya existe, la elimina y crea una nueva (reemplaza la tabla)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
        // Llama a onCreate para crear la tabla de nuevo
        onCreate(db);
    }

}
