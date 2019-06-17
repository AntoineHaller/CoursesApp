package email.app.com.appcourses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Database {

    private String nom_bdd = "courses.db";
    private int version_bdd = 1;

    private SQLiteDatabase bdd;
    private DataBaseHelper mybdd;

    public Database(Context context){
        this.mybdd = new DataBaseHelper(context, this.nom_bdd, null, this.version_bdd);
    }

    public void open(){
        //ouvrir acces bdd
        this.bdd = this.mybdd.getWritableDatabase();
    }

    public void close(){
        //fermer acces bdd
        this.bdd.close();
    }

    public SQLiteDatabase getBDD(){
        //récupérer un accès à la bdd (faut passer par open() avant)
        return this.bdd;
    }

    public long insertCourses(Courses valeur){
        //permet d'inserer un étudiant dans la bdd
        ContentValues cv = new ContentValues();
        cv.put("objet", valeur.getObjet());
        cv.put("quantite", valeur.getQuantite());
        cv.put("important", valeur.isImportant()?1:0); //1 si vrai 0 si faut

        return this.bdd.insert("ETUDIANT", null, cv);
    }

    public List<Courses> getAllCourses(){
        //récupérer contenu ETUDIANT (bdd) sous la forme d'une liste d'objets
        List<Courses> resultat = new ArrayList<>();

        Cursor curseur = this.bdd.rawQuery("SELECT * FROM COURSES;", null);

        while (curseur.moveToNext()) {

            Courses tmp = new Courses();

            tmp.setObjet(curseur.getString(curseur.getColumnIndex("objet")));
            tmp.setQuantite(curseur.getInt(curseur.getColumnIndex("quantite")));
            tmp.setImportant(curseur.getInt(curseur.getColumnIndex("important"))==1?true:false);

            resultat.add(tmp);
        }

        curseur.close();

        return resultat;
    }
}
