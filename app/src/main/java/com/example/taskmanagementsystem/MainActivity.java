package com.example.taskmanagementsystem;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView responseTextView;
    private String host = "82.179.140.18";
    private int port = 45683;
    // Создание объекта SocketManager
    //SocketManager socketManager;
    boolean isConnected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SocketManager.connectParallel(host,port);
        //SocketManager.sendParallel("Select ")
        //boolean isConnected = SocketManager.getConnect();
    }

    public void SingInAccount(View v){

        Intent intent = new Intent(this,PersonalAccountActivity.class);
        startActivity(intent);
    }
}