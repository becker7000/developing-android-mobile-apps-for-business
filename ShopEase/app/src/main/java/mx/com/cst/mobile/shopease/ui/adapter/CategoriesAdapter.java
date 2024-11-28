package mx.com.cst.mobile.shopease.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.com.cst.mobile.shopease.R;
import mx.com.cst.mobile.shopease.model.Category;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    // Lista de categorías que el adaptador va a mostrar
    private List<Category> categories;

    // Constructor que recibe la lista de categorías
    public CategoriesAdapter(List<Category> categories) {
        this.categories = categories;
    }

    // Este método infla el layout de cada item para las categorías
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada elemento de la categoría
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        // Devolvemos un nuevo ViewHolder que contiene la vista inflada
        return new CategoryViewHolder(view);
    }

    // Este método se llama para vincular los datos del producto con la vista del ViewHolder
    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        // Obtenemos la categoría actual en la posición
        Category category = categories.get(position);

        // Establecemos el nombre de la categoría en el TextView
        holder.categoryName.setText(category.getName());

        // Usamos Picasso para cargar la imagen de la categoría en el ImageView
        Picasso.get().load(category.getImageUrl()).into(holder.categoryImage);
    }

    // Este método devuelve el número total de categorías que tenemos en la lista
    @Override
    public int getItemCount() {
        return categories.size();
    }

    // ViewHolder para cada elemento en la lista de categorías
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        // Variables para los elementos de la UI
        TextView categoryName;
        ImageView categoryImage;

        // Constructor que recibe la vista del item
        public CategoryViewHolder(View itemView) {
            super(itemView);
            // Inicializamos los componentes de la vista con sus IDs
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryImage = itemView.findViewById(R.id.categoryImage);
        }
    }
}
