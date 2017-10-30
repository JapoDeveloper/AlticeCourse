package co.japo.layoutsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;

/**
 * Created by japodeveloper on 9/15/17.
 */

public class WebSiteAdapter extends ArrayAdapter<WebModel> {

    private String tipoActivity;

    public WebSiteAdapter(Context context,List<WebModel> datos, String tipo){
        super(context,0,datos);
        this.tipoActivity = tipo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            if(tipoActivity.equals("listView"))
                convertView = inflater.inflate(
                        R.layout.activity_list_view_item,
                        parent,
                        false);
            else if(tipoActivity.equals("gridView"))
                convertView = inflater.inflate(
                        R.layout.activity_grid_view_item,
                        parent,
                        false);
        }

        // Referencias UI.
        ImageView icon = (ImageView) convertView.findViewById(R.id.item_icon);
        TextView label = (TextView) convertView.findViewById(R.id.item_label);

        // Web actual.
        WebModel web = getItem(position);

        // Setup.
        Glide.with(getContext()).load(web.getImage()).into(icon);
        label.setText(web.getDescription());

        return convertView;
    }
}
