package com.example.taskmanagementsystem;



import static java.lang.Boolean.TRUE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private TextView responseTextView;
    private String host = "82.179.140.18";
    private int port = 45683;
    public static String idClient="";
    public static String name="";
    public static String surname="";
    public static String organization="";
    public static String post="";
    boolean isConnected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SocketManager.connectParallel(host,port);
    }

    public void SingInAccount(View v){
        EditText login = (EditText) findViewById(R.id.editTextText);
        EditText passwd = (EditText) findViewById(R.id.editTextTextPassword);
        SocketManager.sendParallel("Select * from accounts where login='"+login.getText()+"' and passwd='"+passwd.getText()+"'");
        SocketManager.receiveParallel();
        String buf=SocketManager.getResult();
        if(!buf.equals(" ")) {
            String[] ClientInfo = buf.split("\t");
            idClient = ClientInfo[0];
            name = ClientInfo[3];
            surname = ClientInfo[4];
            organization = ClientInfo[5];
            post = ClientInfo[6];
            Intent intent = new Intent(this, PersonalAccountActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Неверный логин или пароль!", Toast.LENGTH_SHORT).show();
        }


    }
}