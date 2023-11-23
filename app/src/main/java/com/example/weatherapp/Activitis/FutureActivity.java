package com.example.weatherapp.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weatherapp.Adapters.FutureAdapter;
import com.example.weatherapp.Domains.FutureDomain;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private FutureAdapter adapterTommorow;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FutureActivity.this,MainActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items=new ArrayList<>();

        items.add(new FutureDomain("Sat","storm","Storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","Cloudy",24,16));
        items.add(new FutureDomain("Mon","windy","Windy",29,15));
        items.add(new FutureDomain("Tue","cloudy_sunny","Cloudy Sunny",22,13));
        items.add(new FutureDomain("Wen","sunny","Sunny",28,11));
        items.add(new FutureDomain("Thu","rainy","Rainy",23,12));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTommorow=new FutureAdapter(this,items);
        recyclerView.setAdapter(adapterTommorow);
    }
}