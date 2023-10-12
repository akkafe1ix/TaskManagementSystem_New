package com.example.taskmanagementsystem;

import static com.example.taskmanagementsystem.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class EmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_employees);

        List<Employees> employees = new ArrayList<Employees>();
        employees.add(new Employees(1,"Leonov","Nick","President"));


        GridView gridView = (GridView) findViewById(id.gridView);
        gridView.setAdapter(new EmployeesAdapter(this, employees));
        gridView.setAdapter(new EmployeesAdapter(this, employees));
    }

    public void BackInAccount(View view){
        Intent intent = new Intent(this,PersonalAccountActivity.class);
        startActivity(intent);
    }
}