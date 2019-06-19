package email.app.com.appcourses;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CoursesAdapter extends BaseAdapter {

    private Context context;
    private List<Courses> datas;

    public CoursesAdapter(Context context, List<Courses> datas) {
        this.context = context;
        this.datas = datas;
    }

    //Permet de récupérer le nombre d'éléments de la liste
    @Override
    public int getCount() {
        return this.datas.size();
    }

    //Permet de récupérer un élément à une position donnée
    @Override
    public Object getItem(int position) {
        return this.datas.get(position);
    }

    //Permet de récupérer l'id (attribut) d'un éléments à une position donnée, plus détaillé que getItem
    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.row, null);
        }

        Courses current = (Courses) getItem(position);

        TextView tv_objet = convertView.findViewById(R.id.tv_row_objet);
        tv_objet.setText(current.getObjet());

        TextView tv_quantite = convertView.findViewById(R.id.tv_row_quantite);
        String text = "Quantité: "+current.getQuantite();
        tv_quantite.setText(text);

        if (current.isImportant()){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.monRouge));
        }

        if (!current.isImportant()){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.monBleu));
        }

        return convertView;
    }
}