package com.nelson.tda.imc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtEstatura, txtPeso;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEstatura = (EditText) findViewById(R.id.txtEstatura);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCalcularOnClick();
            }
        });
    }

    private void btnCalcularOnClick() {

        try {
            float peso = Float.parseFloat(txtPeso.getText().toString());
            float estatura= Float.parseFloat(txtEstatura.getText().toString());
            float imc= peso/(estatura*estatura);
            String mensaje ="";
            if(imc<18){
                mensaje="Peso bajo Necesario valorar por desnutricion";
            }else if(imc>=18 && imc <=24.9){
                mensaje="Normal buena salud";
            }else if (imc>=25 && imc <=26.9){
                mensaje="Sobrepeso";
            }else if (imc>=27 && imc <=29.9){
                mensaje="Obesidad grado I  Riesgo relativo alto para desarrollar enfermedades cardiovasculares";
            }else if (imc>=30 && imc <=39.9){
                mensaje="Obesidad grado II. Riesgo relativo muy alto para desarrollar enfermedades cardiovasculares";
            }else if (imc>=40){
                mensaje="Obesidad grado III. Extrema o morbida Riesgo relativo extremadamente alto para desarrollar enfermedades cardiovasculares";
            }
            AlertDialog.Builder dialogo= new AlertDialog.Builder(this);
            dialogo.setCancelable(true);
            dialogo.setMessage(mensaje+ " -"+imc);
            dialogo.setTitle("IMC");
            dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            dialogo.create();
            dialogo.show();


        } catch (Exception e) {
            Toast.makeText(MainActivity.this,"Debe Ingresar el Peso y la estatura",Toast.LENGTH_LONG).show();
        }
    }
}