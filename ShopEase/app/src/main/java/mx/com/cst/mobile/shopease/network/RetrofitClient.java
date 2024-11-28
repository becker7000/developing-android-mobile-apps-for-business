package mx.com.cst.mobile.shopease.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Esta clase se encarga de crear y proporcionar la instancia de Retrofit que se usará para realizar las solicitudes HTTP.
public class RetrofitClient {

    // La URL base de la API a la que se van a hacer las solicitudes
    private static final String BASE_URL = "https://fakestoreapi.com/";

    // Instancia de Retrofit que se compartirá en toda la aplicación
    private static Retrofit retrofit;

    // Método estático para obtener la instancia de Retrofit
    // Si la instancia ya existe, la devuelve; de lo contrario, la crea.
    public static Retrofit getRetrofitInstance() {
        // Verificamos si no se ha creado una instancia de Retrofit previamente.
        if (retrofit == null) {
            // Si no existe, creamos una nueva instancia de Retrofit configurada.
            retrofit = new Retrofit.Builder()
                    // Establecemos la URL base de la API
                    .baseUrl(BASE_URL)
                    // Agregamos un convertidor para convertir las respuestas JSON en objetos Java
                    .addConverterFactory(GsonConverterFactory.create()) // Gson convierte JSON a objetos Java
                    .build(); // Construimos la instancia de Retrofit
        }
        // Devolvemos la instancia de Retrofit (ya sea la nueva o la existente)
        return retrofit;
    }
}
