package com.example.ac1part1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Exerc5 extends AppCompatActivity {

    private CheckBox cbNotificacoes, cbModoEscuro, cbLembrarLogin;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exerc5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cbNotificacoes = findViewById(R.id.cbNotificacoes);
        cbModoEscuro = findViewById(R.id.cbModoEscuro);
        cbLembrarLogin = findViewById(R.id.cbLembrarLogin);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPreferencias();
            }
        });
    }

    private void salvarPreferencias() {
        StringBuilder resultado = new StringBuilder();

        if (cbNotificacoes.isChecked()) resultado.append("Receber notificações\n");
        if (cbModoEscuro.isChecked()) resultado.append("Modo escuro\n");
        if (cbLembrarLogin.isChecked()) resultado.append("Lembrar login\n");

        if (resultado.length() > 0) {
            Toast.makeText(this, "Preferências:\n" + resultado.toString(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Nenhuma preferência foi escolhida.", Toast.LENGTH_SHORT).show();
        }
    }
}
