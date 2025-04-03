package com.example.ac1part1;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Exerc3 extends AppCompatActivity {

    private EditText edtNome, edtIdade, edtUF, edtCidade, edtTelefone, edtEmail;
    private RadioGroup rgTamanho;
    private CheckBox cbAzul, cbVermelho, cbVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exerc3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNome = findViewById(R.id.edtNome);
        edtIdade = findViewById(R.id.edtIdade);
        edtUF = findViewById(R.id.edtUF);
        edtCidade = findViewById(R.id.edtCidade);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEmail = findViewById(R.id.edtEmail);
        rgTamanho = findViewById(R.id.rgTamanho);
        cbAzul = findViewById(R.id.cbAzul);
        cbVermelho = findViewById(R.id.cbVermelho);
        cbVerde = findViewById(R.id.cbVerde);

        findViewById(R.id.btnCadastrar).setOnClickListener(v -> {
            String nome = edtNome.getText().toString();
            String idade = edtIdade.getText().toString();
            String uf = edtUF.getText().toString();
            String cidade = edtCidade.getText().toString();
            String telefone = edtTelefone.getText().toString();
            String email = edtEmail.getText().toString();

            int idSelecionado = rgTamanho.getCheckedRadioButtonId();
            RadioButton rbSelecionado = findViewById(idSelecionado);
            String tamanho = rbSelecionado != null ? rbSelecionado.getText().toString() : "Não selecionado";

            Toast.makeText(Activity_Exerc3.this, "Cadastro realizado!", Toast.LENGTH_SHORT).show();
        });
    }
}
