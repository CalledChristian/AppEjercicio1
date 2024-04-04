package com.example.appejercicio1;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appejercicio1.Bean.Persona;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void incrementarContador (View view) {
        TextView textView = findViewById(R.id.contador);
        String contadorStr = textView.getText().toString();
        int contador = Integer.parseInt(contadorStr);
        contador++;
        Log.d ("contador", "" +  String.valueOf(contador));
        textView.setText(String.valueOf(contador));
    }

    //Activity == Otra Ventana
    //Es un componente que represente una ventana, la cual a su vez contiene un
    //conjunto de vistas (views)
    public void irActivity2(View view) {

        //primero crear el intento
        Intent intent = new Intent(this, MainActivity2.class);
        //iniciar activity
        startActivity(intent);

    }

    public void irActivity3(View view) {

        //primero crear el intento

        //Creamos un Intento Explicito para Enviar Información entre Activities
        Intent intent = new Intent(this, MainActivity3.class);
        //Enviar 1 solo parametro - Data
        intent.setData(Uri.parse("https://www.pucp.edu.pe"));

        //Enviar parametros
        intent.putExtra("nombre", "Stephanie");
        intent.putExtra("edad", 20);

        //Enviar Objeto
        Persona persona = new Persona();
        persona.setNombre("Claudia");
        persona.setNombre("Apellido");
        intent.putExtra("alumna", persona);

        //iniciar activity
        startActivity(intent);

    }

        public void irActivity4(View view) {
        //Implict Intent
        //1-Crear un Intent con la acción por realizar
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        //poner info extra
        intent.putExtra(SearchManager.QUERY,"https://www.pucp.edu.pe");

        //2. Validar que el equipo soporta la acción a realizar y lanza el intent… OJO a
        //partir de Android 30, ver siguiente Diapo.

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this,"La accion no es soportada",Toast.LENGTH_SHORT).show();
        }

        }
}