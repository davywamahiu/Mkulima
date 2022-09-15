package com.example.mkulima;

import android.content.Context;
import android.net.ConnectivityManager;

import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActiveBuyers extends AppCompatActivity {

    private List<Buyersmkulima> listData;
    private RecyclerView rv;
    private SupportAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_buyers);


          initializeData();
        /*loadData(new GetAllData() {
            @Override
            public void onDataLoaded(List<Buyersmkulima> listData) {
                listData = new ArrayList<Buyersmkulima>();
                Buyersmkulima myDB = new Buyersmkulima();

                RecyclerView rv = findViewById(R.id.my_recycler_view);
                rv.setLayoutManager(new LinearLayoutManager(ActiveBuyers.this));
                rv.setAdapter(new SupportAdapter(listData));
            }

            @Override
            public void onError(String errorMsg) {

                Toast.makeText(ActiveBuyers.this, errorMsg, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    /*final DatabaseReference nm= FirebaseDatabase.getInstance("https://mkulima-1e15b.firebaseio.com/").getReference("mkulima15");
    public void loadData(final GetAllData listData1) {
        nm.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //List<Buyersmkulima> list = new ArrayList<>();
                for (DataSnapshot adSnapshot : dataSnapshot.getChildren()) {
                    Buyersmkulima f = adSnapshot.getValue(Buyersmkulima.class);
                    listData.add(f);
                }

                listData1.onDataLoaded(listData);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listData1.onError("Error occur while getting Buyersmkulima data");
            }
        });

    }
    public boolean hasParent(String id){
        String fid="";
        boolean status =false;
        for(int i=0;i<listData.size();i++)
        {
            Toast.makeText(this, "FID: "+listData.get(i).getId(), Toast.LENGTH_SHORT).show();
            if(Integer.parseInt(listData.get(i).getId())==Integer.parseInt(id))
            {
                fid = listData.get(i).getFid();

                break;
            }
        }
        for(int i=0; i<listData.size();i++)
        {
            Toast.makeText(this, "Value "+status, Toast.LENGTH_SHORT).show();
            if(Integer.parseInt(listData.get(i).getId())==Integer.parseInt(fid)){
                status= true;
                break;
            }
        }
        // Toast.makeText(this, "Status"+status+mylist.get(47).getId(), Toast.LENGTH_SHORT).show();
        return status;
    }*/
    private void initializeData() {
        listData = new ArrayList<>();
        final DatabaseReference ref = FirebaseDatabase.getInstance("https://mkulima-1e15b.firebaseio.com/").getReference("mkulima15");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue());
                        Buyersmkulima f = dataSnapshot.getValue(Buyersmkulima.class);
                        listData.add(f);

                //at this point you have looped through all the "children" -
                //now you are ready to initialize the adapter
                SupportAdapter adapter = new SupportAdapter(listData);
                rv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.toString());
            }
        });
    }


}
