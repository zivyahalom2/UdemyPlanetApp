package com.example.udemyplanetapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
Context context;
ArrayList<Planet>planetArrayList;
  MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //

        Init();//איתחול הפקדים
        CreatePlanetsAndAddIntoList();//בניית הרשימה


        adapter= new MyCustomAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(adapter);
    }

    private void CreatePlanetsAndAddIntoList() {
        //creating instances of the class
        Planet venus= new Planet("Venus","0",R.drawable.planet1);
        Planet earth= new Planet("earth","1",R.drawable.planet2);
        Planet mars= new Planet("Mars","2",R.drawable.planet3);
        Planet jupiter= new Planet("Jupiter","79",R.drawable.planet4);
        Planet saturen= new Planet("saturen","83",R.drawable.planet5);
        Planet sun= new Planet("sun","1",R.drawable.planet6);
        Planet moon= new Planet("Moon","1",R.drawable.planet7);
        Planet uranus= new Planet("Uranus","27",R.drawable.planet8);
        Planet Pluto= new Planet("Pluto","1",R.drawable.planet8);

        //adding the instance into the array list
        planetArrayList.add(venus);
        planetArrayList.add(earth);
        planetArrayList.add(mars);
        planetArrayList.add(jupiter);
        planetArrayList.add(saturen);
        planetArrayList.add(sun);
        planetArrayList.add(moon);
        planetArrayList.add(uranus);
        planetArrayList.add(Pluto);
    }
    private void Init() {
        context=MainActivity.this;
        listView=findViewById(R.id.listview);
        planetArrayList= new ArrayList<>();
    }
}