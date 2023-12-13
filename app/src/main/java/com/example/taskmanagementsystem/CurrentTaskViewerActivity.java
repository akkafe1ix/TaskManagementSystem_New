package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.taskmanagementsystem.AdapterAndClass.CurrentSecondTaskAdapter;
import com.example.taskmanagementsystem.AdapterAndClass.SecondTask;
import com.example.taskmanagementsystem.AdapterAndClass.SecondTaskAdapter;
import com.example.taskmanagementsystem.AdapterAndClass.SocketManager;

import java.util.ArrayList;
import java.util.List;

public class CurrentTaskViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_task_viewer);

        Bundle bundle = this.getIntent().getExtras();
        SocketManager.sendParallel("Select stask_id, _text, check_complete from secondtask where gtask_id = '"+bundle.getString("idTasks")+"' order by stask_id ASC");
        SocketManager.receiveParallel();
        String buf=SocketManager.getResult();

        TextView textView=(TextView) findViewById(R.id.textView18);
        SocketManager.sendParallel("Select lead_id from globaltask where gtask_id = '"+bundle.getString("idTasks")+"'");
        SocketManager.receiveParallel();
        String eployeesId=SocketManager.getResult();
        String[] emplIdInfo = eployeesId.split("\t");

        SocketManager.sendParallel("Select _name, _secondname, post from accounts where acc_id = '"+emplIdInfo[0]+"'");
        SocketManager.receiveParallel();
        String employeesInfo=SocketManager.getResult();
        String[] emplInfo = employeesInfo.split("\t");

        textView.setText(bundle.getString("Name"));
        textView=(TextView) findViewById(R.id.textView13);
        textView.setText(emplInfo[1]+" "+emplInfo[0]);
        textView=(TextView) findViewById(R.id.textView15);
        textView.setText(emplInfo[2]);

        List<SecondTask> stask = new ArrayList<SecondTask>();
        String[] STaskStroka = buf.split("\n");
        for (int i=0;i<STaskStroka.length;i++){
            String STaskInfo[]=STaskStroka[i].split("\t");
            stask.add(new SecondTask(STaskInfo[0],STaskInfo[1],STaskInfo[2]));
        }


        GridView gridView = (GridView) findViewById(R.id.gridCurTask);
        gridView.setAdapter(new CurrentSecondTaskAdapter(this, stask));
    }

    public void BackInAccount(View view){
        Bundle bundle = this.getIntent().getExtras();
        SocketManager.sendParallel("SELECT COUNT(*) AS count_One FROM secondtask WHERE check_complete = '1' and gtask_id='"+bundle.getString("idTasks")+"'");
        SocketManager.receiveParallel();
        String one= SocketManager.getResult();
        SocketManager.sendParallel("SELECT COUNT(*) AS count_One FROM secondtask WHERE gtask_id='"+bundle.getString("idTasks")+"'");
        SocketManager.receiveParallel();
        String all= SocketManager.getResult();
        if(all.equals(one)){
            SocketManager.sendParallel("UPDATE globaltask SET check_complete='1' WHERE gtask_id='"+bundle.getString("idTasks")+"'");
            SocketManager.receiveParallel();
        }
        Intent intent = new Intent(this,CurrentTaskActivity.class);
        startActivity(intent);
        this.finish();
    }
}