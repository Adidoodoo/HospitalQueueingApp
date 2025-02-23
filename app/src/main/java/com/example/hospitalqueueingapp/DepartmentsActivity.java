package com.example.hospitalqueueingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DepartmentsAdapter adapter;
    private List<Departments> specialtyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_departments);

        recyclerView = findViewById(R.id.recycler_view);

        // Create list of specialties
        specialtyList = new ArrayList<>();
        specialtyList.add(new Departments("Emergency Room (ER)"));
        specialtyList.add(new Departments("Outpatient Department (OPD)"));
        specialtyList.add(new Departments("Internal Medicine"));
        specialtyList.add(new Departments("Pediatrics"));
        specialtyList.add(new Departments("Obstetrics and Gynecology (OB-GYN)"));
        specialtyList.add(new Departments("Orthopedics"));
        specialtyList.add(new Departments("Cardiology"));
        specialtyList.add(new Departments("Dentistry"));
        specialtyList.add(new Departments("Dermatology"));
        specialtyList.add(new Departments("Radiology"));

        adapter = new DepartmentsAdapter(specialtyList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycler_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}