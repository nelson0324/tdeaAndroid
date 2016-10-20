package co.com.nelson.basesdedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import db.IMCSqlite;

public class ListaActivity extends AppCompatActivity {

    private IMCSqlite imcsqLite;
    private SQLiteDatabase db;
    private ListView personas;
    int mayores=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        imcsqLite= new IMCSqlite(this);
        db= imcsqLite.getReadableDatabase();
        personas =(ListView)findViewById(R.id.lstPersonas);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,llenarLista());
        personas.setAdapter(adapter);
        Toast.makeText(this, "mayores de edad"+ mayores,Toast.LENGTH_LONG).show();

    }

    private ArrayList<String> llenarLista(){
        ArrayList<String> lista = new ArrayList<String>();

        Cursor c =db.rawQuery("Select * from tblimc",null);
        while(c.moveToNext()){
            if(c.getInt(c.getColumnIndex("edad"))>=18) {
                mayores ++;
            }
            lista.add(c.getString(c.getColumnIndex("nombre")));
        }

        return  lista;
    }
}
