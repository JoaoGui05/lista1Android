package com.example.ac1part1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Exerc1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exerc1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editTextNome = findViewById(R.id.editTextText);
        EditText editTextIdade = findViewById(R.id.editTextText2);
        Button buttonVerificar = findViewById(R.id.button);
        TextView textViewResultado = findViewById(R.id.textView3);

        // Evento de clique no botão "Verificar"
        buttonVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                String idadeString = editTextIdade.getText().toString();

                if (nome.isEmpty() || idadeString.isEmpty()) {
                    textViewResultado.setText("Por favor, preencha todos os campos.");
                    return;
                }

                try {
                    int idade = Integer.parseInt(idadeString);
                    if (idade >= 18) {
                        textViewResultado.setText(nome + ", você é maior de idade.");
                    } else {
                        textViewResultado.setText(nome + ", você é menor de idade.");
                    }
                } catch (NumberFormatException e) {
                    textViewResultado.setText("Idade inválida. Por favor, insira um número válido.");
                }
            }
        });
    }
}
