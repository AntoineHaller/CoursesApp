package email.app.com.appcourses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class NewItemActivity extends AppCompatActivity {

    private EditText objet;
    private EditText quantite;
    private CheckBox important;
    private Button btn_creer;
    private Button btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item);

        btn_creer = (Button) findViewById(R.id.btn_creer);
        objet = (EditText) findViewById(R.id.objet);
        quantite = (EditText) findViewById(R.id.quantite);
        important = (CheckBox)findViewById(R.id.important);

        btn_creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Courses e = new Courses(
                        objet.getText().toString(),
                        important.isChecked(),
                        quantite.getText().toString()
                );

                Database bdd = new Database(NewItemActivity.this);
                bdd.open();
                bdd.insertCourses(e);
                bdd.close();

                Intent a = new Intent(NewItemActivity.this, NewItemActivity.class);
                startActivity(a);

            }
        });

        btn_list = (Button) findViewById(R.id.btn_list);

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewItemActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

    }
}
