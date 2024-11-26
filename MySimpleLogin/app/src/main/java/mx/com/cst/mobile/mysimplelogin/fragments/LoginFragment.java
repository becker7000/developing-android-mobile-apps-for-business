package mx.com.cst.mobile.mysimplelogin.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

import mx.com.cst.mobile.mysimplelogin.R;
import mx.com.cst.mobile.mysimplelogin.models.User;

public class LoginFragment extends Fragment {

    private TextInputLayout tilCampoUsuario;
    private TextInputLayout tilCampoContra;
    private Button btnLogin;

    private User usuario = new User("erick123", "12345678");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Si hay argumentos, puedes procesarlos aquí.
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla la vista para este fragmento
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tilCampoUsuario = view.findViewById(R.id.tilCampoUsuario);
        tilCampoContra = view.findViewById(R.id.tilCampoContra);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            // Obtener los valores de los campos de texto cada vez que se hace clic en el botón
            String textoCampoUsuario = tilCampoUsuario.getEditText().getText().toString();
            String textoCampoContra = tilCampoContra.getEditText().getText().toString();

            // Verificar si los campos de texto tienen el formato adecuado
            if (!textoCampoUsuario.isEmpty() && textoCampoUsuario.length() >= 6 && !textoCampoContra.isEmpty() && textoCampoContra.length() >= 8 && textoCampoContra.length() <= 15) {

                if (textoCampoUsuario.equals(usuario.getName()) && textoCampoContra.equals(usuario.getPass())) {
                    tilCampoUsuario.setError(null);

                    // Si las credenciales son correctas, navegar al siguiente fragmento
                    StartFragment fragment2 = StartFragment.newInstance(tilCampoUsuario.getEditText().getText().toString());
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, fragment2)
                            .addToBackStack("firstContainer")
                            .commit();
                } else {
                    Toast.makeText(getContext(), "Usuario o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                    tilCampoUsuario.getEditText().setText("");
                    tilCampoContra.getEditText().setText("");
                }

            } else {
                if (textoCampoUsuario.isEmpty() || textoCampoUsuario.length() < 6) {
                    tilCampoUsuario.setError("El usuario debe al menos tener 6 caracteres.");
                }

                if (textoCampoContra.isEmpty() || textoCampoContra.length() < 8 || textoCampoContra.length() > 15) {
                    tilCampoContra.setError("La contraseña debe contener entre 8 y 15 caracteres.");
                }
            }
        });
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}
