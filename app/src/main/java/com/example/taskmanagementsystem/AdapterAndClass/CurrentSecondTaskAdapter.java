package com.example.taskmanagementsystem.AdapterAndClass;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.taskmanagementsystem.CreateTasksActivity;

import java.util.List;

public class CurrentSecondTaskAdapter extends BaseAdapter {
    private Context context;
    private List<SecondTask> secondtask;

    public CurrentSecondTaskAdapter(Context context, List<SecondTask> secondtask) {
        this.context = context;
        this.secondtask = secondtask;
    }

    @Override
    public int getCount() {
        return secondtask.size();
    }

    @Override
    public Object getItem(int position) {
        return secondtask.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        if (convertView == null) {
            button = new Button(context);
            button.setText(secondtask.get(position).getNameTask());
            if(secondtask.get(position).getCheck().equals("0")){
                int color = Color.parseColor("#FF0000");
                button.setTextColor(color);
            }
            else{
                int color = Color.parseColor("#32CD32");
                button.setTextColor(color);
            }

            //Создает обработчик событий
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(secondtask.get(position).getCheck().equals("0")){
                        int color = Color.parseColor("#32CD32");
                        secondtask.get(position).setCheck("1");
                        SocketManager.sendParallel("UPDATE secondtask SET check_complete='1' WHERE stask_id='"+secondtask.get(position).getIdTask()+"'");
                        SocketManager.receiveParallel();
                        button.setTextColor(color);
                    }
                    else{
                        int color = Color.parseColor("#FF0000");
                        secondtask.get(position).setCheck("0");
                        SocketManager.sendParallel("UPDATE secondtask SET check_complete='0' WHERE stask_id='"+secondtask.get(position).getIdTask()+"'");
                        SocketManager.receiveParallel();
                        button.setTextColor(color);
                    }
                };
            });
        } else {
            button = (Button) convertView;
        }
        button.setId(position);

        return button;
    }

    //Сплитуем строчку на слова
    public String SplitString(Integer num,String str){
        String[] words = str.split("\\s");
        return words[num];
    }
}
