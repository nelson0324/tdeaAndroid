package co.com.nelson.basesdedatos;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import db.IMCSqlite;

public class MainActivity extends AppCompatActivity {
   private  IMCSqlite imcSqlite= new IMCSqlite(MainActivity.this);
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=imcSqlite.getWritableDatabase();
    }
}
