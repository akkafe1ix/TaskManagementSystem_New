package com.example.taskmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.taskmanagementsystem.AdapterAndClass.SecondTask;
import com.example.taskmanagementsystem.AdapterAndClass.SecondTaskAdapter;
import com.example.taskmanagementsystem.AdapterAndClass.SocketManager;

import java.util.ArrayList;
import java.util.List;

public class CompleteTaskViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_task_viewer);

        Bundle bundle = this.getIntent().getExtras();
        SocketManager.sendParallel("Select stask_id, _text, check_complete from secondtask where gtask_id = '"+bundle.getString("idTasks")+"' order by stask_id ASC");
        SocketManager.receiveParallel();
        String buf=SocketManager.getResult();

        TextView textView=(TextView) findViewById(R.id.textView27);
        SocketManager.sendParallel("Select subject_id from globaltask where gtask_id = '"+bundle.getString("idTasks")+"'");
        SocketManager.receiveParallel();
        String eployeesId=SocketManager.getResult();
        String[] emplIdInfo = eployeesId.split("\t");

        SocketManager.sendParallel("Select _name, _secondname, post from accounts where acc_id = '"+emplIdInfo[0]+"'");
        SocketManager.receiveParallel();
        String employeesInfo=SocketManager.getResult();
        String[] emplInfo = employeesInfo.split("\t");

        SocketManager.sendParallel("SELECT COUNT(*) AS count_One FROM secondtask WHERE check_complete = '1' and gtask_id='"+bundle.getString("idTasks")+"'");
        SocketManager.receiveParallel();
        String SCheckOne= SocketManager.getResult();
        String SplinCheckOne[]=SCheckOne.split("\t");
        Double CheckOne= Double.parseDouble(SplinCheckOne[0]);

        SocketManager.sendParallel("SELECT COUNT(*) AS count_All FROM secondtask WHERE gtask_id='"+bundle.getString("idTasks")+"'");
        SocketManager.receiveParallel();
        String SAll= SocketManager.getResult();
        String SplinAll[]=SAll.split("\t");
        Double All= Double.parseDouble(SplinAll[0]);

        Double procent=(CheckOne/All)*100;

        textView.setText(bundle.getString("Name"));
        textView=(TextView) findViewById(R.id.textView25);
        textView.setText(emplInfo[1]+" "+emplInfo[0]);
        textView=(TextView) findViewById(R.id.textView26);
        textView.setText(emplInfo[2]);
        textView=(TextView) findViewById(R.id.textView191);
        String strprocent=String.valueOf(Math.round(procent));
        textView.setText(strprocent+"%");

        List<SecondTask> stask = new ArrayList<SecondTask>();
        String[] STaskStroka = buf.split("\n");
        for (int i=0;i<STaskStroka.length;i++){
            String STaskInfo[]=STaskStroka[i].split("\t");
            stask.add(new SecondTask(STaskInfo[0],STaskInfo[1],STaskInfo[2]));
        }


        GridView gridView = (GridView) findViewById(R.id.gridTaskComplete);
        gridView.setAdapter(new SecondTaskAdapter(this, stask));
    }

    public void BackInAccount(View view){
        Intent intent = new Intent(this,CompleteTaskActivity.class);
        startActivity(intent);
        this.finish();
    }
}