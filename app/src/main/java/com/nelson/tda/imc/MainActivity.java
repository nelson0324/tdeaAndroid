package com.nelson.tda.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtEstatura,txtPeso;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEstatura=(EditText) findViewById(R.id.txtEstatura);
        txtPeso=(EditText) findViewById(R.id.txtPeso);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    btnCalcularOnClick();
            }
        });
    }

    private void btnCalcularOnClick() {
    }
}
