package com.example.mkulima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapta /*extends BaseAdapter*/ {

    /*private ArrayList<DatabaseHelper> DatabaseHelpersList;
    private Context context;

    public CustomAdapta(ArrayList<DatabaseHelper> list, Context cont){
        this.DatabaseHelpersList = list;
        this.context = cont;
    }

    @Override
    public int getCount() {
        return this.DatabaseHelpersList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.DatabaseHelpersList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.list_view, null);

            holder = new ViewHolder();
            holder.id = (TextView)convertView.findViewById(R.id.text_dogID);
            holder.name = (TextView)convertView.findViewById(R.id.text_dogName);
            holder.age = (TextView)convertView.findViewById(R.id.text_dogAge);
            holder.weight = (TextView)convertView.findViewById(R.id.text_dogWeight);
            holder.breed = (TextView)convertView.findViewById(R.id.text_dogBreed);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        DatabaseHelper stu = DatabaseHelpersList.get(position);
        holder.id.setText(stu.getID());
        holder.name.setText(stu.getName());
        holder.age.setText(stu.getAge());
        holder.weight.setText(stu.getWeight());
        holder.breed.setText(stu.getBreed());

        return convertView;
    }

    private static class ViewHolder{
        public TextView id;
        public TextView name;
        public TextView age;
        public TextView weight;
        public TextView breed;
    }*/
}
