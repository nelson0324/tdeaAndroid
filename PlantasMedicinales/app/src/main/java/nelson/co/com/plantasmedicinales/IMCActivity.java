package nelson.co.com.plantasmedicinales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IMCActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtPeso, txtEstatura;
    private Button btnCalcular, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        txtEstatura = (EditText) findViewById(R.id.txtEstatura);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        btnCalcular = (Button) findViewById(R.id.btnAceptar);
        btnCalcular.setOnClickListener(this);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        //clase de java que permite pasar los valores entre actividades
        Bundle b = new Bundle();
        try {


            switch (view.getId()) {

                case R.id.btnAceptar:
                        float peso =Float.parseFloat(txtPeso.getText().toString());
                        float estatura =Float.parseFloat(txtEstatura.getText().toString());
                        b.putString("status","done");
                        b.putFloat("imcValor",peso/(estatura*estatura));
                        Intent intent = new Intent();
                        intent.putExtras(b);
                        setResult(RESULT_OK,intent);
                        finish();

                    break;
                case R.id.btnCancelar:
                        b.putString("status","undone");
                        Intent i = new Intent();
                        i.putExtras(b);
                        setResult(RESULT_CANCELED,i);
                        finish();

                    break;

            }
        } catch (Exception e) {

                b.putString("status","error"+e);


        }

    }
}
