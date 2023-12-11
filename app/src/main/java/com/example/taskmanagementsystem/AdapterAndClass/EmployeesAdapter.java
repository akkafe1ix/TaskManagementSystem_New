package com.example.taskmanagementsystem.AdapterAndClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.taskmanagementsystem.AdapterAndClass.Employees;
import com.example.taskmanagementsystem.CreateTasksActivity;

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
            button.setText(employees.get(position).getPost()+" - "+employees.get(position).getSurname()+" "+employees.get(position).getName());
            
            //Создает обработчик событий
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Переход на другую активити с передачей данных
                    Bundle bundle = new Bundle();
                    //String fullname=SplitString(2,(String)button.getText())
                    //        +" "+SplitString(3,(String)button.getText());
                    String strochka=(String)button.getText();
                    String Stroka[] = strochka.split("-");
                    bundle.putString("fulname",Stroka[1]);
                    bundle.putString("post",Stroka[0]);
                    bundle.putString("idEmployees",employees.get(position).getId());
                    Intent intent = new Intent(v.getContext(), CreateTasksActivity.class);
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
