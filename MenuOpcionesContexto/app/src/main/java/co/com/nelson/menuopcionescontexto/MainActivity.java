package co.com.nelson.menuopcionescontexto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_ppal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.opt_caseros:
                Toast.makeText(MainActivity.this, "Remedios caseros", Toast.LENGTH_LONG).show();
                break;
            case R.id.opt_ajo:
                Intent i= new Intent(MainActivity.this,AjoActivity.class);
                startActivity(i);
                break;

            case R.id.opt_remolacha:
                Intent a= new Intent(MainActivity.this,RemolachaActivity.class);
                startActivity(a);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
