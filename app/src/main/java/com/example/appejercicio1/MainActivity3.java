package com.example.appejercicio1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appejercicio1.Bean.Persona;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        /*La actividad que es creada con
        Intent, accede a esta por
        medio de getIntent();*/
        Intent intent = getIntent();
        Uri data = intent.getData();
        Log.d("data",data.toString());
        //Recibimos los parametros
        String nombre = intent.getStringExtra("nombre");
        int edad = intent.getIntExtra("edad",0);
        Persona alumna = (Persona) intent.getSerializableExtra("alumna");
    }
}