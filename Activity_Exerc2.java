package com.example.ac1part1;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import java.text.BreakIterator;

public class Activity_Exerc2 extends AppCompatActivity {

    private EditText num1, num2;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exerc2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        txtResultado = findViewById(R.id.txtResultado);

        findViewById(R.id.btnSoma).setOnClickListener(v -> calcular('+'));
        findViewById(R.id.btnSubtrai).setOnClickListener(v -> calcular('-'));
        findViewById(R.id.btnMultiplica).setOnClickListener(v -> calcular('*'));
        findViewById(R.id.btnDivide).setOnClickListener(v -> calcular('/'));
    }

    private void calcular(char operacao) {
        double valor1 = Double.parseDouble(num1.getText().toString());
        double valor2 = Double.parseDouble(num2.getText().toString());
        double resultado = 0;

        switch (operacao) {
            case '+': resultado = valor1 + valor2; break;
            case '-': resultado = valor1 - valor2; break;
            case '*': resultado = valor1 * valor2; break;
            case '/': resultado = valor2 != 0 ? valor1 / valor2 : 0; break;
        }

        txtResultado.setText("Resultado: " + resultado);
    }
}
