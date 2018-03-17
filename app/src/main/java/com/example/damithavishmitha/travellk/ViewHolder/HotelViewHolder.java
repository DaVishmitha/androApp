package com.example.damithavishmitha.travellk.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damithavishmitha.travellk.Interface.ItemClickListener;
import com.example.damithavishmitha.travellk.R;

/**
 * Created by DamithaVishmitha on 3/15/2018.
 */

public class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView hotel_name;
    public ImageView hotel_image;
    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public HotelViewHolder(View itemView) {
        super(itemView);

        hotel_name = (TextView)itemView.findViewById(R.id.hotel_name);
        hotel_image = (ImageView)itemView.findViewById(R.id.hotel_image);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
