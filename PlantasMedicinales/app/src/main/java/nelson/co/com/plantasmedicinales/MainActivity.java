package nelson.co.com.plantasmedicinales;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstPlanta;
    private static final int IR_A_IMC=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPlanta= (ListView) findViewById(R.id.lstPlantasMedicinales);
        String [ ] datosLista={"Dietas","Plantas naturales", "Recetas", "IMC","OTRAS"};
        ArrayList<String> datos= new ArrayList<String>();
        datos.add("Dietas");
        datos.add("Plantas naturales");
        datos.add("Recetas");
        datos.add("Imc");
        datos.add("Otras");

        //ArrayAdapter(Activida,estructura, datos)
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        lstPlanta.setAdapter(adaptador);
        lstPlanta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item=lstPlanta.getItemAtPosition(i).toString();

                switch (item){
                    case "Imc":
                        Intent intent = new Intent(MainActivity.this,IMCActivity.class);
                        //startActivity(intent);
                        startActivityForResult(intent,IR_A_IMC);
                        break;


                }

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultcode, Intent dato){

                switch (requestCode){

                    case IR_A_IMC:
                            if(resultcode==RESULT_OK){
                                Bundle b= new Bundle();
                                b= dato.getExtras();
                                if(b.getString("status").equals("done")){

                                    AlertDialog.Builder dialogo= new AlertDialog.Builder(this);
                                    dialogo.setTitle("Imc");
                                    dialogo.setMessage("Su imc es "+ b.getFloat("imcValor"));
                                    dialogo.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                            dialogInterface.dismiss();

                                        }
                                    });

                                    dialogo.create();
                                    dialogo.show();
                                }
                            }
                        break;

                }


    }



}
