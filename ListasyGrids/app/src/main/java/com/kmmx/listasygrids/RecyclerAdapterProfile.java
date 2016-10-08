package com.kmmx.listasygrids;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Gorro on 01/10/16.
 */

public class RecyclerAdapterProfile extends RecyclerView.Adapter<RecyclerAdapterProfile.RecyclerAdapterViewHolder> {

    private Context context;
    private List<ItemList> data;

    public RecyclerAdapterProfile(Context context, List<ItemList> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewAdapter = (LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null));
        RecyclerAdapterViewHolder adapterViewHolder = new RecyclerAdapterViewHolder(viewAdapter);
        return adapterViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterViewHolder holder, final int position) {
        if (data.get(position).getImgUrl() == null) {
            holder.imageView.setImageResource(data.get(position).getImg());
        } else {
            Picasso.with(context).load(data.get(position).getImgUrl()).placeholder(android.R.drawable.ic_delete).into(holder.imageView);
        }
        holder.txtTitle.setText(data.get(position).getTitulo());
        holder.txtSubTitle.setText(data.get(position).getSubtitulo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtTitle;
        TextView txtSubTitle;

        public RecyclerAdapterViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgItemList);
            txtTitle = (TextView) itemView.findViewById(R.id.txtItemTitle);
            txtSubTitle = (TextView) itemView.findViewById(R.id.txtItemSubTitle);
        }
    }

}
