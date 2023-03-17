package com.example.testeq1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> numeros = new ArrayList<Integer>();
    private EditText edtNumero;
    private TextView txtNumeros;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero = findViewById(R.id.edtNumero);
        txtNumeros = findViewById(R.id.txtNumeros);

        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroStr = edtNumero.getText().toString();
                if (numeroStr.isEmpty()) {
                    return;
                }
                int numero = Integer.parseInt(numeroStr);
                numeros.add(numero);
                Collections.sort(numeros);
                txtNumeros.setText(numeros.toString());
                edtNumero.setText("");
            }
        });
        Button btnGerar = findViewById(R.id.btnGerar);
        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = "lista.txt";
                String fileContents = txtNumeros.getText().toString();
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    outputStream.write(fileContents.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
