package mx.com.cst.mobile.mysimplelogin.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import mx.com.cst.mobile.mysimplelogin.R;

public class StartFragment extends Fragment {

    private TextView tvBienvenida;
    private String texto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            texto = getArguments().getString(USUARIO_ARG, "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvBienvenida = view.findViewById(R.id.textoBienvenida);
        tvBienvenida.setText("Bienvenid@ " + texto);
    }

    public static final String USUARIO_ARG = "USUARIO_ARG";

    public static StartFragment newInstance(String usuario) {
        StartFragment fragment = new StartFragment();
        Bundle args = new Bundle();
        args.putString(USUARIO_ARG, usuario);
        fragment.setArguments(args);
        return fragment;
    }

}
