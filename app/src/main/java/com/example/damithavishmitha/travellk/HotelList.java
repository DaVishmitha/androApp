package com.example.damithavishmitha.travellk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.damithavishmitha.travellk.Interface.ItemClickListener;
import com.example.damithavishmitha.travellk.Model.Hotel;
import com.example.damithavishmitha.travellk.ViewHolder.HotelViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HotelList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference hotelList;
    String categoryId="";
    FirebaseRecyclerAdapter<Hotel,HotelViewHolder>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        database = FirebaseDatabase.getInstance();
        hotelList=database.getReference("Hotel");
        recyclerView=(RecyclerView)findViewById(R.id.recycler_hotel);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //get intent
        if (getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if (!categoryId.isEmpty()&&categoryId!=null){
            loadListHotel(categoryId);
        }

    }
    private void loadListHotel(String categoryId){
        adapter = new FirebaseRecyclerAdapter<Hotel, HotelViewHolder>(Hotel.class,R.layout.hotel_item,HotelViewHolder.class,hotelList.orderByChild("LocationID").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(HotelViewHolder viewHolder, Hotel model, int position) {
                viewHolder.hotel_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.hotel_image);
                final Hotel local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent hotelDetail = new Intent(HotelList.this,HotelDetails.class);
                        hotelDetail.putExtra("HotelId",adapter.getRef(position).getKey());
                        startActivity(hotelDetail);
                    }
                });

            }
        };
        //adapter

        recyclerView.setAdapter(adapter);

    }
}
