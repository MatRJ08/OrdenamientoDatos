package com.example.tareaextraclase3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView numeroIteracion;
    private TextView iteracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroIteracion = (TextView) findViewById(R.id.textIteracion);
        iteracion = (TextView) findViewById(R.id.textDatos);

    }

    public void sortSelection(View v){
        numeroIteracion.setText("Iteracion #1");
        iteracion.setText("02, 01, 03");
    }
}
