package co.com.nelson.menuopcionescontexto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class AjoActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajo);
        img =(ImageView) findViewById(R.id.img);
        registerForContextMenu(img);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_ajo:
                Intent i =new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://ecoinventos.com/plantas-medicinales-que-podemos-cultivar-en-casa/#ajo"));
                startActivity(i);

        }
        return super.onContextItemSelected(item);
    }
}
