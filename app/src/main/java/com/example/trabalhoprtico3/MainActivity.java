package com.example.trabalhoprtico3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public  final static String SALARIO_BRUTO = "com.example.intent.SALARIO";
    public  final static String OUTROS_DESCONTOS = "com.example.intent.DESCONTOS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calcular(View view){
        EditText input_Salario = (EditText)findViewById(R.id.inputSalarioBruto) ;
        EditText input_Descontos = (EditText)findViewById(R.id.inputOutrosDescontos);


        Intent Result = new Intent(this, ResultActivity.class);

        Result.putExtra(SALARIO_BRUTO, input_Salario.getText().toString());
        Result.putExtra(OUTROS_DESCONTOS, input_Descontos.getText().toString());


        startActivity(Result);

    }



}