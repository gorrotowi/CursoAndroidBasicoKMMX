package kmmx.dinamicfragments;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Gorro on 22/10/16.
 */

public class ListAdapter extends ArrayAdapter<ItemPersona> {

    ItemPersona[] itemPersonas;
    int resourceLayout;
    private Context ctx;

    public ListAdapter(Context context, int resource, ItemPersona[] itemPersonas) {
        super(context, resource, itemPersonas);
        ctx = context;
        resourceLayout = resource;
        this.itemPersonas = itemPersonas;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
        View adaterView = inflater.inflate(resourceLayout, null);

        TextView txtSquare = (TextView) adaterView.findViewById(R.id.txtItemLetter);
        TextView txtTitle = (TextView) adaterView.findViewById(R.id.txtItemTitle);
        TextView txtSubtitle = (TextView) adaterView.findViewById(R.id.txtItemSubTitle);

        if (position % 2 == 0) {
            txtSquare.setBackgroundColor(ctx.getResources().getColor(R.color.colorAccent));
        } else {
            txtSquare.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimaryDark));
        }

        txtSquare.setText(String.valueOf(itemPersonas[position].getNombre().toUpperCase().charAt(0)));
        txtTitle.setText(itemPersonas[position].getNombre());
        txtSubtitle.setText(itemPersonas[position].getCorreo());

        return adaterView;
    }
}
