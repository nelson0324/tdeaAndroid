package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Estudiante10 on 05/10/2016.
 */
public class IMCSqlite extends SQLiteOpenHelper {

    private  static final String DB_NAME="db_imc";
    private  static final int VERSION_DB=1;

    public IMCSqlite(Context context) {
        super(context, DB_NAME, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "Create table if not exists tblimc ("+
                "id integer not null primary key,"+
                "nombre text not null," +
                "edad integer not null," +
                "peso float not null," +
                "estatura float not null )";

         sqLiteDatabase.execSQL(sql);
         sql= "Create table if not exists tblestadosimc ("+
                "id integer not null primary key,"+
                "concepto text not null," +
                "inicia integer not null," +
                "termina integer not null)";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists tblimc");
        sqLiteDatabase.execSQL("drop table if exists tblestadosimc");

        String sql= "Create table if not exists tblimc ("+
                "id integer not null primary key,"+
                "nombre text not null," +
                "edad integer not null," +
                "peso float not null," +
                "estatura float not null)";

        sqLiteDatabase.execSQL(sql);

        sql= "Create table if not exists tblestadosimc ("+
                "id integer not null primary key,"+
                "concepto text not null," +
                "inicia integer not null," +
                "termina integer not null)";

        sqLiteDatabase.execSQL(sql);

    }
}
