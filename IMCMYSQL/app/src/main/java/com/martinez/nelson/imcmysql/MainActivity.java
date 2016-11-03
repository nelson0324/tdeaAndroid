package com.martinez.nelson.imcmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
  private TabHost thimc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thimc =(TabHost) findViewById(R.id.tabHost);
        thimc.setup();
        TabHost.TabSpec persona = thimc.newTabSpec("Personas");
        persona.setIndicator("",getResources().getDrawable(R.drawable.personas));
        persona.setContent(R.id.tabPersonas);

        TabHost.TabSpec tablas = thimc.newTabSpec("Tablas");
        tablas.setIndicator("",getResources().getDrawable(R.drawable.escalas));
        tablas.setContent(R.id.tabPersonas);

        TabHost.TabSpec tratamientos = thimc.newTabSpec("Tratamientos");
        tratamientos.setIndicator("",getResources().getDrawable(R.drawable.tratamientos));
        tratamientos.setContent(R.id.tabTratamientos);

        thimc.addTab(persona);
        thimc.addTab(tablas);
        thimc.addTab(tratamientos);


    }
}
