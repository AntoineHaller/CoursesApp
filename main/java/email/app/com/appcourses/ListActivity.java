package email.app.com.appcourses;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView lv_items;
    private Button btn_ajouter;
    private Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv_items = (ListView) findViewById(R.id.lv_courses);

        final CoursesAdapter adapter = new CoursesAdapter(ListActivity.this, load());

        lv_items.setAdapter(adapter);

        lv_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Courses selected = (Courses) parent.getItemAtPosition(position);
                //TODO changer couleur selected
            }
        });


        btn_ajouter = (Button) findViewById(R.id.btn_ajouter);

        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListActivity.this, NewItemActivity.class);
                startActivity(i);
            }
        });

        btn_delete = (Button) findViewById(R.id.btn_delete);

        lv_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Courses selected = (Courses) parent.getItemAtPosition(position);
                //TODO supp selected
            }
        });

    }

    //création de la soures de donnée via le contenu de la base de données
    public List<Courses> load(){
        Database db = new Database(ListActivity.this);
        db.open();
        List<Courses> datas = db.getAllCourses();
        db.close();

        return datas;
    }
}
