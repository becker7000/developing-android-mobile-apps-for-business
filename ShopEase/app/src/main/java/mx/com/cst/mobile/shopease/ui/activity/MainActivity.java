package mx.com.cst.mobile.shopease.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;

import mx.com.cst.mobile.shopease.R;
import mx.com.cst.mobile.shopease.model.Category;
import mx.com.cst.mobile.shopease.model.Product;
import mx.com.cst.mobile.shopease.network.ApiService;
import mx.com.cst.mobile.shopease.network.RetrofitClient;
import mx.com.cst.mobile.shopease.ui.adapter.CategoriesAdapter;
import mx.com.cst.mobile.shopease.ui.adapter.ProductsAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Variables de UI que se utilizarán para los componentes de la actividad
    private EditText searchBar;
    private RecyclerView categoriesRecyclerView;
    private RecyclerView featuredProductsRecyclerView;

    // Método onCreate que se ejecuta cuando la actividad es creada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout que se usará en esta actividad
        setContentView(R.layout.activity_main);

        // Inicialización de los componentes de la UI
        searchBar = findViewById(R.id.searchBar); // Barra de búsqueda
        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView); // RecyclerView para categorías
        featuredProductsRecyclerView = findViewById(R.id.featuredProductsRecyclerView); // RecyclerView para productos destacados

        // Configuración del RecyclerView para mostrar categorías
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Establecer el adaptador para categorías con datos estáticos
        categoriesRecyclerView.setAdapter(new CategoriesAdapter(getCategories()));

        // Configuración del RecyclerView para productos destacados
        featuredProductsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Obtener los productos destacados desde la API
        getFeaturedProducts();
    }

    // Método para obtener las categorías de forma estática (ejemplo simple)
    private List<Category> getCategories() {
        // Creamos una lista de categorías
        List<Category> categories = new ArrayList<>();
        // Añadimos varias categorías con nombre e imagen
        categories.add(new Category("Electronics", "https://fakestoreapi.com/img/81QpkIctqPL._AC_SX679_.jpg"));
        categories.add(new Category("Jewelery", "https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg"));
        categories.add(new Category("Men's clothing", "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg"));
        categories.add(new Category("Women's clothing", "https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg"));
        return categories; // Devolvemos la lista de categorías
    }

    // Método para obtener productos destacados desde la API utilizando Retrofit
    private void getFeaturedProducts() {
        // Creamos una instancia de Retrofit utilizando el cliente previamente configurado
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        // Creamos la instancia del servicio API que define los endpoints
        ApiService apiService = retrofit.create(ApiService.class);

        // Realizamos una llamada para obtener los productos (endpoint: /products)
        Call<List<Product>> call = apiService.getProducts();

        // Enviamos la solicitud de manera asíncrona
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                // Si la respuesta fue exitosa y no está vacía
                if (response.isSuccessful() && response.body() != null) {
                    List<Product> products = response.body(); // Obtenemos la lista de productos

                    // Creamos el adaptador para productos y lo asignamos al RecyclerView
                    ProductsAdapter productsAdapter = new ProductsAdapter(products);
                    featuredProductsRecyclerView.setAdapter(productsAdapter);
                } else {
                    // Si la respuesta fue exitosa pero la lista de productos está vacía, mostramos un mensaje
                    Toast.makeText(MainActivity.this, "Error en la respuesta de la API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Si ocurre un error en la conexión o la solicitud
                Toast.makeText(MainActivity.this, "Error en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                // Registramos el error en el log para depuración
                Log.e("MainActivity", "Error: " + t.getMessage());
            }
        });
    }
}
