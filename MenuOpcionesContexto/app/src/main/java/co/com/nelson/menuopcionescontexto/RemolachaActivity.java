package co.com.nelson.menuopcionescontexto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class RemolachaActivity extends AppCompatActivity {
    private ImageView imageRemolacha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_remolacha);
        imageRemolacha=(ImageView) findViewById(R.id.img_remolacha);
        registerForContextMenu(imageRemolacha);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto_remolacha,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_remolacha:
                Intent i =new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://mejorconsalud.com/6-beneficios-las-remolachas-le-aportan-salud"));
                startActivity(i);

        }
        return super.onContextItemSelected(item);
    }


}
