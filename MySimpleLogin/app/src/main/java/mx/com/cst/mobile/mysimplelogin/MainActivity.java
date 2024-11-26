package mx.com.cst.mobile.mysimplelogin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import mx.com.cst.mobile.mysimplelogin.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Crear una nueva instancia del fragmento
            LoginFragment fragment1 = LoginFragment.newInstance();

            // Iniciar la transacción
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            // Definir la transacción
            fragmentTransaction.add(
                    R.id.fragmentContainer,
                    fragment1
            );

            // Confirmar la transacción
            fragmentTransaction.commit();
        }
    }
}
