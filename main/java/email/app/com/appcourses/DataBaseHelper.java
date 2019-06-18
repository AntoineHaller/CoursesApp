package email.app.com.appcourses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Appelée auto si la bdd existe pas
        db.execSQL("CREATE TABLE COURSES (objet TEXT, quantite TEXT, important INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //quand la bdd est modifié (numéro)
        db.execSQL("DROP TABLE COURSES;");
        onCreate(db);
    }
}