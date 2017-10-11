package com.example.ayush.customdialogapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 10/11/2017.
 */

public class customAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Data> list;
    private LayoutInflater mLayoutInflator;
    //parameterized constructor
    public customAdapter(Context context, ArrayList list){
        this.context=context;
        this.list=list;
        //Layout Inflator
        mLayoutInflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        //returns list Size
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        //Returns item
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        //returns position
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflating layout
        convertView = mLayoutInflator.inflate(R.layout.row_layout,null);
        //associating TextViews with their respective ids
        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView email = (TextView)convertView.findViewById(R.id.email);
        TextView dob = (TextView)convertView.findViewById(R.id.dob);
        //setting data in these TextViews
        name.setText(list.get(position).getName());
        email.setText(String.valueOf(list.get(position).getEmail()));
        dob.setText(list.get(position).getDate());
        //return view
        return convertView;
    }
}
