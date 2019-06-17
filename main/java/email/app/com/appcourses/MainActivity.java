package email.app.com.appcourses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText objet;
    private EditText quantite;
    private CheckBox important;
    private Button btn_creer;
    private Button btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        Integer.parseInt(quantite.getText().toString())
                );

                Database bdd = new Database(MainActivity.this);
                bdd.open();
                bdd.insertCourses(e);
                bdd.close();

            }
        });

        btn_list = (Button) findViewById(R.id.btn_list);

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });


    }

}
