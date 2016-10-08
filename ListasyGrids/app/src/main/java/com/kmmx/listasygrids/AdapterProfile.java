package com.kmmx.listasygrids;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gorro on 01/10/16.
 */

public class AdapterProfile extends BaseAdapter {

    private Context context;
    private int layoutResource;
    private ArrayList<ItemList> itemLists = new ArrayList<>();

    public AdapterProfile(Context context, int layoutResource, ArrayList<ItemList> itemLists) {
        this.context = context;
        this.layoutResource = layoutResource;
        this.itemLists = itemLists;
    }

    @Override
    public int getCount() {
        return itemLists.size();
    }

    @Override
    public Object getItem(int position) {
        return itemLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View fila = convertView;
        ViewHolder holder = null;
        if (fila == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            fila = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();
            holder.imgProfile = (ImageView) fila.findViewById(R.id.imgItemList);
            holder.txtTitulo = (TextView) fila.findViewById(R.id.txtItemTitle);
            holder.txtSubtitle = (TextView) fila.findViewById(R.id.txtItemSubTitle);
            holder.txtTitulo.setTextColor(context.getResources().getColor(R.color.colorAccent));
//            holder.checkBox = (CheckBox) fila.findViewById(R.id.ckItemList);
            fila.setTag(holder);
        } else {
            holder = (ViewHolder) fila.getTag();
        }

        final ItemList item = (ItemList) itemLists.get(position);
        holder.txtTitulo.setText(item.getTitulo());
        holder.txtSubtitle.setText(item.getSubtitulo());
        holder.imgProfile.setImageResource(item.getImg());

//        fila.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, item.getTitulo() + "\n" + item.getSubtitulo(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked)
//                    Toast.makeText(context, item.getTitulo(), Toast.LENGTH_SHORT).show();
//            }
//        });

        return fila;
    }

    class ViewHolder {
        TextView txtTitulo, txtSubtitle;
        ImageView imgProfile;
        CheckBox checkBox;
    }
}
