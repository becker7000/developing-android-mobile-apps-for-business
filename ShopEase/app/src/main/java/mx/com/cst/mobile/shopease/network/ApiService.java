package mx.com.cst.mobile.shopease.network;

// Importamos la clase Product, que representa el modelo de datos para los productos.
import mx.com.cst.mobile.shopease.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {

    // Definimos el endpoint "products" que devolverá una lista de productos.
    // La anotación @GET indica que realizaremos una solicitud GET a este endpoint.
    @GET("products")
    // El método getProducts() devuelve un objeto Call que contiene una lista de productos (de tipo Product).
    // El objeto Call se utilizará para realizar la solicitud HTTP y manejar la respuesta.
    Call<List<Product>> getProducts();
}
