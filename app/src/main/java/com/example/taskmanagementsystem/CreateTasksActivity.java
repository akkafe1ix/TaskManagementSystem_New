package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreateTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tasks);
        TextView FulName= findViewById(R.id.textView6);
        TextView Post= findViewById(R.id.textView8);
        Bundle bundle = this.getIntent().getExtras();
        FulName.setText(bundle.getString("fulname"));
        Post.setText(bundle.getString("post"));
    }

    public void NoCreateTask(View view){
        Intent intent = new Intent(this,EmployeesActivity.class);
        startActivity(intent);
    }

    public void CreateTask(View view){
        Intent intent = new Intent(this,EmployeesActivity.class);
        startActivity(intent);
    }
}