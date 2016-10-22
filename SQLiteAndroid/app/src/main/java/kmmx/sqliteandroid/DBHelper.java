package kmmx.sqliteandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Gorro
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "Curso";
    public static final String _ID = "id";
    static final String DBNAME = "KMMXAndroidBasico.db";
    static final int DBVERSION = 1;

    String sqliteCreate = "CREATE TABLE " + TABLE_NAME + " ( " + _ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, " +
            "edad INTEGER, " +
            "domicilio TEXT ); ";

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqliteCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST Curso");
        db.execSQL(sqliteCreate);
    }
}
