package com.example.taskmanagementsystem;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class EmployeesAdapter extends BaseAdapter {
    private Context context;
    private List<Employees> employees;

    public EmployeesAdapter(Context context, List<Employees> employees) {
        this.context = context;
        this.employees = employees;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
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
            button.setText(employees.get(position).getPost()+" "+employees.get(position).getSurname()+" "+employees.get(position).getName());
            
            //Создает обработчик событий
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Переход на другую активити с передачей данных
                    Bundle bundle = new Bundle();
                    String fullname=SplitString(1,(String)button.getText())
                            +" "+SplitString(2,(String)button.getText());
                    bundle.putString("fulname",fullname);
                    bundle.putString("post",SplitString(0,(String)button.getText()));
                    Intent intent = new Intent(v.getContext(),CreateTasksActivity.class);
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
