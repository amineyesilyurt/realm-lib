package com.example.realm_examples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<PersonInfos> list;
    Context context;

    public Adapter(List<PersonInfos> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView name= convertView.findViewById(R.id.name);
        TextView username = convertView.findViewById(R.id.userName);
        TextView pass= convertView.findViewById(R.id.pass);
        TextView sex= convertView.findViewById(R.id.sex);
        name.setText(list.get(position).getName());
        username.setText(list.get(position).getUsername());
        pass.setText(list.get(position).getPass());
        sex.setText(list.get(position).getSex());
        return convertView;
    }
}
