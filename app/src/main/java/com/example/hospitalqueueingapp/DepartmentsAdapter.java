package com.example.hospitalqueueingapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.DepartmentsViewHolder> {

    private List<Departments> departments;

    public DepartmentsAdapter(List<Departments> departments) {
        this.departments = departments;
    }

    @Override
    public DepartmentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_departments_adapter, parent, false);
        return new DepartmentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DepartmentsViewHolder holder, int position) {
        Departments department = departments.get(position);
        holder.departmentText.setText(department.getName());
    }

    @Override
    public int getItemCount() {
        return departments.size();
    }

    public static class DepartmentsViewHolder extends RecyclerView.ViewHolder {
        TextView departmentText;

        public DepartmentsViewHolder(View itemView) {
            super(itemView);
            departmentText = itemView.findViewById(R.id.text_departments);
        }
    }
}
