package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalAccountActivity extends AppCompatActivity {

    public boolean EditBool= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_account);
        TextView SurnameText = findViewById(R.id.editTextText3);
        SurnameText.setText(MainActivity.surname);
        TextView NameText = findViewById(R.id.editTextText6);
        NameText.setText(MainActivity.name);
        TextView OrganizationText = findViewById(R.id.editTextText8);
        OrganizationText.setText(MainActivity.organization);
        TextView PostText = findViewById(R.id.editTextText9);
        PostText.setText(MainActivity.post);




    }

    public void ExitInAccount(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void OpenAssignedTasksActivity(View v){
        Intent intent = new Intent(this,AssignedTasksActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void OpenEmployeesActivity(View v){
        Intent intent = new Intent(this,EmployeesActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void OpenCurrentActivity(View v){
        Intent intent = new Intent(this,CurrentTaskActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void OpenCompleteTask(View v){
        Intent intent = new Intent(this,CompleteTaskActivity.class);
        startActivity(intent);
        this.finish();
    }
}