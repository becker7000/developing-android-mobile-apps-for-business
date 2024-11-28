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
import mx.com.cst.mobile.shopease.model.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    // Lista de productos que el adaptador va a mostrar
    private List<Product> products;

    // Constructor que recibe la lista de productos
    public ProductsAdapter(List<Product> products) {
        this.products = products;
    }

    // Este método infla el layout de cada item para los productos
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout para cada elemento del producto
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        // Devolvemos un nuevo ViewHolder que contiene la vista inflada
        return new ProductViewHolder(view);
    }

    // Este método se llama para vincular los datos del producto con la vista del ViewHolder
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        // Obtenemos el producto actual en la posición
        Product product = products.get(position);

        // Establecemos el nombre y el precio del producto en los TextViews correspondientes
        holder.productName.setText(product.getTitle());
        holder.productPrice.setText(product.getPrice());

        // Usamos Picasso para cargar la imagen del producto en el ImageView
        Picasso.get().load(product.getImage()).into(holder.productImage);
    }

    // Este método devuelve el número total de productos que tenemos en la lista
    @Override
    public int getItemCount() {
        return products.size();
    }

    // ViewHolder para cada elemento en la lista de productos
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        // Variables para los elementos de la UI
        TextView productName;
        TextView productPrice;
        ImageView productImage;

        // Constructor que recibe la vista del item
        public ProductViewHolder(View itemView) {
            super(itemView);
            // Inicializamos los componentes de la vista con sus IDs
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }

}
