package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonalAccountActivity extends AppCompatActivity {

    public boolean EditBool= true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_account);
    }
    public void StartEditProfile(View view){

        TextView SurnameText = findViewById(R.id.editTextText3);
        TextView NameText = findViewById(R.id.editTextText6);
        TextView OrganizationText = findViewById(R.id.editTextText8);
        TextView PostText = findViewById(R.id.editTextText9);
        Button ButEditSave= findViewById(R.id.button2);
        SurnameText.setEnabled(EditBool);
        SurnameText.setFocusable(EditBool);
        NameText.setEnabled(EditBool);
        NameText.setFocusable(EditBool);
        OrganizationText.setEnabled(EditBool);
        OrganizationText.setFocusable(EditBool);
        PostText.setEnabled(EditBool);
        PostText.setFocusable(EditBool);
        if (EditBool==false){
            EditBool=true;
            ButEditSave.setText("Редактировать");
        } else{
            EditBool=false;
            ButEditSave.setText("Сохранить");
        }
    }

    public void ExitInAccount(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void OpenAssignedTasksActivity(View v){
        Intent intent = new Intent(this,AssignedTasksActivity.class);
        startActivity(intent);
    }

    public void OpenEmployeesActivity(View v){
        Intent intent = new Intent(this,EmployeesActivity.class);
        startActivity(intent);
    }
}