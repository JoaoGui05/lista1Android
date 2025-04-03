package com.example.ac1part1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_Exerc4 extends AppCompatActivity {

    private EditText edtNome;
    private LinearLayout layoutCheckboxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exerc4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtNome = findViewById(R.id.edtNome);
        layoutCheckboxes = findViewById(R.id.layoutCheckboxes);

        edtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                atualizarCheckboxes(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void atualizarCheckboxes(String nome) {
        layoutCheckboxes.removeAllViews();
        for (char letra : nome.toCharArray()) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(String.valueOf(letra));
            layoutCheckboxes.addView(checkBox);
        }
    }
}
