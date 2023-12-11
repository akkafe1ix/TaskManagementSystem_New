package com.example.taskmanagementsystem;

import static com.example.taskmanagementsystem.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.taskmanagementsystem.AdapterAndClass.Employees;
import com.example.taskmanagementsystem.AdapterAndClass.EmployeesAdapter;
import com.example.taskmanagementsystem.AdapterAndClass.SocketManager;

import java.util.ArrayList;
import java.util.List;

public class EmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_employees);

        SocketManager.sendParallel("Select acc_id, _secondname, _name, post from accounts where acc_id <> '"+MainActivity.idClient+"'");
        SocketManager.receiveParallel();
        String buf=SocketManager.getResult();
        List<Employees> employees = new ArrayList<Employees>();
        String[] ClientStroka = buf.split("\n");
        for (int i=0;i<ClientStroka.length;i++){
            String ClientInfo[]=ClientStroka[i].split("\t");
            employees.add(new Employees(ClientInfo[0],ClientInfo[1],ClientInfo[2],ClientInfo[3]));
        }


        GridView gridView = (GridView) findViewById(id.gridView);
        gridView.setAdapter(new EmployeesAdapter(this, employees));
    }

    public void BackInAccount(View view){
        Intent intent = new Intent(this,PersonalAccountActivity.class);
        startActivity(intent);
    }
}