package com.example.taskmanagementsystem.AdapterAndClass;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.taskmanagementsystem.AdapterAndClass.SecondTask;

import java.util.List;

public class SecondTaskAdapter extends BaseAdapter {
    private Context context;
    private List<SecondTask> secondtask;

    public SecondTaskAdapter(Context context, List<SecondTask> secondtask) {
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
        EditText editText;
        if (convertView == null) {
            editText = new EditText(context);
            editText.setText(secondtask.get(position).getNameTask());
            if(secondtask.get(position).getCheck().equals("0")){
                int color = Color.parseColor("#FF0000");
                editText.setTextColor(color);
                editText.setFocusable(false);
                editText.setFocusableInTouchMode(false);
                editText.setClickable(false);
            }
            else{
                int color = Color.parseColor("#32CD32");
                editText.setTextColor(color);
                editText.setFocusable(false);
                editText.setFocusableInTouchMode(false);
                editText.setClickable(false);
            }
        } else {
            editText = (EditText) convertView;
        }
        editText.setId(position);

        return editText;
    }

    //Сплитуем строчку на слова
    public String SplitString(Integer num,String str){
        String[] words = str.split("\\s");
        return words[num];
    }
}
