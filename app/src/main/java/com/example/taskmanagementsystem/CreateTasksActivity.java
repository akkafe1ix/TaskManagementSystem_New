package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateTasksActivity extends AppCompatActivity {

    public int count=0;
    String idEmployees="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tasks);
        TextView FulName= findViewById(R.id.textView6);
        TextView Post= findViewById(R.id.textView8);
        Bundle bundle = this.getIntent().getExtras();
        FulName.setText(bundle.getString("fulname"));
        Post.setText(bundle.getString("post"));
        idEmployees=bundle.getString("idEmployees");
    }

    public void NoCreateTask(View view){
        Intent intent = new Intent(this,EmployeesActivity.class);
        startActivity(intent);
    }

    public void CreateTask(View view){
        EditText editText=findViewById(R.id.editTextText2);
        if(!editText.getText().toString().equals("Задача")){
            SocketManager.sendParallel("INSERT INTO globaltask (taskname, lead_id, subject_id, check_complete) VALUES ('"+editText.getText().toString()+"', '"+MainActivity.idClient+"', '"+idEmployees+"','0')");
        }
        SocketManager.sendParallel("Select gtask_id from globaltask where taskname = '"+editText.getText().toString()+"' and lead_id ='"+MainActivity.idClient+"' and subject_id='"+idEmployees+"'");
        SocketManager.receiveParallel();
        String gtask=SocketManager.getResult();

        editText=findViewById(R.id.editTextText17);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        editText=findViewById(R.id.editTextText18);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        editText=findViewById(R.id.editTextText19);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        editText=findViewById(R.id.editTextText20);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        editText=findViewById(R.id.editTextText21);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        editText=findViewById(R.id.editTextText22);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        editText=findViewById(R.id.editTextText23);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        editText=findViewById(R.id.editTextText24);
        if(!editText.getText().toString().equals("Подзадача")){
            SocketManager.sendParallel("INSERT INTO secondtask (gtask_id, _text, check_complete) VALUES ('"+gtask+"', '"+editText.getText().toString()+"', '0')");
            SocketManager.receiveParallel();
        }
        Intent intent = new Intent(this,EmployeesActivity.class);
        startActivity(intent);
    }
}