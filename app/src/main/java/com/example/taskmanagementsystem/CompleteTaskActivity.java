package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.taskmanagementsystem.AdapterAndClass.CopmpleteTaskAdapter;
import com.example.taskmanagementsystem.AdapterAndClass.SocketManager;
import com.example.taskmanagementsystem.AdapterAndClass.Tasks;
import com.example.taskmanagementsystem.AdapterAndClass.TasksAdapter;

import java.util.ArrayList;
import java.util.List;

public class CompleteTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_task);

        SocketManager.sendParallel("Select gtask_id, taskname from globaltask where lead_id = '"+MainActivity.idClient+"' and check_complete='1'");
        SocketManager.receiveParallel();
        String buf=SocketManager.getResult();
        if (!buf.equals(" ")) {
            List<Tasks> tasks = new ArrayList<Tasks>();
            String[] TasksStroka = buf.split("\n");
            for (int i = 0; i < TasksStroka.length; i++) {
                String TasksInfo[] = TasksStroka[i].split("\t");
                tasks.add(new Tasks(TasksInfo[0], TasksInfo[1]));
            }


            GridView gridView = (GridView) findViewById(R.id.gridViewComplete);
            gridView.setAdapter(new CopmpleteTaskAdapter(this, tasks));
        }
    }

    public void BackInAccount(View view){
        Intent intent = new Intent(this,PersonalAccountActivity.class);
        startActivity(intent);
        this.finish();
    }
}