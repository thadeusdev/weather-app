package com.example.weatherapp.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherapp.Adapters.HourlyAdapters;
import com.example.weatherapp.Domains.Hourly;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private RecyclerView.Adapter adapterHourly;
   private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        setVariable();
    }

    private void setVariable() {
        TextView next7dayBtn=findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FutureActivity.class));
            }
        });
    }

    private void initRecyclerview() {
        ArrayList<Hourly> items=new ArrayList<>();

        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sunny"));
        items.add(new Hourly("12 pm",30,"wind"));
        items.add(new Hourly("1 am",29,"rainy"));
        items.add(new Hourly("2 am",27,"storm"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly=new HourlyAdapters(this,items);
        recyclerView.setAdapter(adapterHourly);
    }
}