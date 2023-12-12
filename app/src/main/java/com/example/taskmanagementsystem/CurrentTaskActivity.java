package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.taskmanagementsystem.AdapterAndClass.CurrentTaskAdapter;
import com.example.taskmanagementsystem.AdapterAndClass.SocketManager;
import com.example.taskmanagementsystem.AdapterAndClass.Tasks;

import java.util.ArrayList;
import java.util.List;

public class CurrentTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_task);

        SocketManager.sendParallel("Select gtask_id, taskname from globaltask where subject_id = '"+MainActivity.idClient+"' and check_complete='0'");
        SocketManager.receiveParallel();
        String buf=SocketManager.getResult();
        if (!buf.equals(" ")) {
            List<Tasks> tasks = new ArrayList<Tasks>();
            String[] TasksStroka = buf.split("\n");
            for (int i = 0; i < TasksStroka.length; i++) {
                String TasksInfo[] = TasksStroka[i].split("\t");
                tasks.add(new Tasks(TasksInfo[0], TasksInfo[1]));
            }


            GridView gridView = (GridView) findViewById(R.id.gridCur);
            gridView.setAdapter(new CurrentTaskAdapter(this, tasks));
        }

    }

    public void BackInAccount(View view){
        Intent intent = new Intent(this,PersonalAccountActivity.class);
        startActivity(intent);
    }
}