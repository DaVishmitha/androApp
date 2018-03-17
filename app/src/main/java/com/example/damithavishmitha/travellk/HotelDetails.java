package com.example.damithavishmitha.travellk;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.damithavishmitha.travellk.Model.Hotel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class HotelDetails extends AppCompatActivity {

    TextView hotel_name,hotel_price,hotel_description;
    ImageView hotel_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ElegantNumberButton numberButton;
    String hotelId="";
    FloatingActionButton btnBooking;
    FirebaseDatabase database;
    DatabaseReference hotels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        //Firebase
        database = FirebaseDatabase.getInstance();
        hotels = database.getReference("Hotel");
        //view
        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnBooking = (FloatingActionButton)findViewById(R.id.btnBooking);
        hotel_description = (TextView)findViewById(R.id.hotel_description);
        hotel_name = (TextView)findViewById(R.id.hotel_name);
        hotel_price = (TextView)findViewById(R.id.hotel_price);
        hotel_image = (ImageView)findViewById(R.id.img_hotel);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExapandedAppbar);

        //get id from intent
        if (getIntent() != null)
            hotelId = getIntent().getStringExtra("HotelId");
        if (!hotelId.isEmpty()){
            getDetailsHotel(hotelId);
        }



    }
    private void getDetailsHotel(String hotelId){
        hotels.child(hotelId);
        hotels.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Hotel hotel = dataSnapshot.getValue(Hotel.class);
                //
                //String val = dataSnapshot.getValue(String.class);

                //


               // assert hotel != null;
                Picasso.with(getBaseContext()).load(hotel.getImage())
                        .into(hotel_image);

                collapsingToolbarLayout.setTitle(hotel.getName());

                hotel_price.setText(hotel.getPrice());

                hotel_name.setText(hotel.getName());

                hotel_description.setText(hotel.getDescription());

                //hotel.getDescription()
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
