package co.com.nelson.basesdedatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;

import db.IMCSqlite;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   private  IMCSqlite imcSqlite= new IMCSqlite(MainActivity.this);
    private SQLiteDatabase db;
    private EditText txtNombre,txtEdad,txtPeso,txtEstatura;
    private Button btnGuardar,btnEliminar, btnActualizar, btnEstadistica,btnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=imcSqlite.getWritableDatabase();
        txtNombre= (EditText) findViewById(R.id.txtNombre);
        txtEdad= (EditText) findViewById(R.id.txtEdad);
        txtPeso= (EditText) findViewById(R.id.txtpeso);
        txtEstatura= (EditText) findViewById(R.id.txtEstatura);

        btnGuardar= (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);
        btnEstadistica= (Button) findViewById(R.id.btnEstadistica);
        btnEstadistica.setOnClickListener(this);
        btnActualizar= (Button) findViewById(R.id.btnActualizar);
        btnActualizar.setOnClickListener(this);
        btnEliminar= (Button) findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(this);

        btnLista= (Button) findViewById(R.id.btnLista);
        btnLista.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnLista){

            Intent i = new Intent(MainActivity.this,ListaActivity.class);
            startActivity(i);


        }//fin listar
        if (view==btnGuardar) {
        if(validarDatos()){
                try {
                    ContentValues registro = new ContentValues();
                    registro.put("nombre", txtNombre.getText().toString());
                    registro.put("edad", Integer.parseInt(txtEdad.getText().toString()));
                    registro.put("peso", Float.parseFloat(txtPeso.getText().toString()));
                    registro.put("estatura", Float.parseFloat(txtEstatura.getText().toString()));
                    if( db.insert("tblimc",null, registro) >0) {
                        Toast.makeText(this, "Se inserto correctamente", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(this,"Error No se pudo insertar",Toast.LENGTH_SHORT).show();



                }catch (Exception e){

                    e.printStackTrace();
                    Toast.makeText(this,"Error No se pudo insertar",Toast.LENGTH_SHORT).show();
                }

            }else {

            Toast.makeText(MainActivity.this,"Debe ingresar todos los datos",Toast.LENGTH_SHORT).show();
            }

        }//fin guardar
        if (view==btnActualizar){
            if(validarDatos()){
                try {
                    ContentValues registro = new ContentValues();
                    registro.put("edad", Integer.parseInt(txtEdad.getText().toString()));
                    registro.put("peso", Float.parseFloat(txtPeso.getText().toString()));
                    registro.put("estatura", Float.parseFloat(txtEstatura.getText().toString()));
                    if( db.update("tblimc",registro,"nombre='"+txtNombre.getText().toString()+"'",null)>0) {
                        Toast.makeText(this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(this,"Error No se pudo Actualizar",Toast.LENGTH_SHORT).show();

                }catch (Exception e){

                    e.printStackTrace();
                    Toast.makeText(this,"Error No se pudo insertar",Toast.LENGTH_SHORT).show();
                }

            }else {

                Toast.makeText(MainActivity.this,"Debe ingresar todos los datos",Toast.LENGTH_SHORT).show();
            }
        } if (view==btnEliminar){

            if (txtNombre.getText().length()==0){
                Toast.makeText(MainActivity.this,"Debe ingresar el nombre",Toast.LENGTH_SHORT).show();
            }else{

                if(db.delete("tblimc","nombre='"+txtNombre.getText().toString()+"'",null)>0){
                    Toast.makeText(MainActivity.this,"Se elemino correctamente",Toast.LENGTH_SHORT).show();

                }
            }

        }

    }

    private void limpiar(){
            txtNombre.setText("");
            txtEdad.setText("");
            txtEstatura.setText("");
            txtPeso.setText("");
    }

    private boolean validarDatos(){

        if(txtNombre.getText().toString().length()==0  ||
                txtEdad.getText().toString().length()==0 ||
                txtPeso.getText().toString().length()==0 ||
        txtEstatura.getText().toString().length()==0)
            return false;
        return true;
    }
}
