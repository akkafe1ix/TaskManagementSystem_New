package com.example.taskmanagementsystem;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

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
            button.setText(employees.get(position).getSurname()+" "+employees.get(position).getName());
            //Создает обработчик событий
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Пока что тут вывод на профиль
                    Intent intent = new Intent(v.getContext(),PersonalAccountActivity.class);
                    context.startActivity(intent);
                }
            });

        } else {
            button = (Button) convertView;
        }
        button.setId(position);

        return button;
    }
}
