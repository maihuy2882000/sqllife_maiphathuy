package com.example.sql_life_demo_maiphathuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class lvApdapter extends BaseAdapter {

    Context ctx;
    int layoutItem;
    List<Student> arrayList;
    public lvApdapter(Context ctx, int layoutItem, List<Student> arrayList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(ctx).inflate(layoutItem,parent,false);
        TextView tvid = convertView.findViewById(R.id.tvid);
        String a = String.valueOf(arrayList.get(position).getId());
        tvid.setText(a);
        TextView tvName = convertView.findViewById(R.id.tvName);
        tvName.setText(arrayList.get(position).getName());

        return convertView;
    }
}
