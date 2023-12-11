package com.example.taskmanagementsystem.AdapterAndClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.taskmanagementsystem.AdapterAndClass.Tasks;
import com.example.taskmanagementsystem.CurrentTaskViewerActivity;

import java.util.List;

public class CurrentTaskAdapter extends BaseAdapter {
    private Context context;
    private List<Tasks> tasks;

    public CurrentTaskAdapter(Context context, List<Tasks> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
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
            button.setText(tasks.get(position).getName());

            //Создает обработчик событий
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Переход на другую активити с передачей данных
                    Bundle bundle = new Bundle();
                    bundle.putString("idTasks",tasks.get(position).getId());
                    bundle.putString("Name",tasks.get(position).getName());
                    Intent intent = new Intent(v.getContext(), CurrentTaskViewerActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
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
