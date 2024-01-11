package com.example.weatherapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.Domains.Hourly;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class HourlyAdapters extends RecyclerView.Adapter<HourlyAdapters.viewholder> {


   ArrayList<Hourly>items;

    public HourlyAdapters(ArrayList<Hourly> items) {
        this.items = items;
    }

    Context context;

    @NonNull
    @Override
    public HourlyAdapters.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyAdapters.viewholder holder, int position) {
        holder.hourTxt.setText(items.get(position).getHour());
        holder.tempTxt.setText(items.get(position).getTemp()+"");
        int drawableResourceid=holder.itemView.getResources().getIdentifier(items.get(position).getPicPath(),"drawable"
        ,holder.itemView.getContext().getPackageName());
     Glide.with(context).load(drawableResourceid).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class viewholder extends RecyclerView.ViewHolder{
        TextView hourTxt,tempTxt;
        ImageView img;
        public viewholder(View itemview){
            super(itemview);
            hourTxt=itemview.findViewById(R.id.txt5);
            tempTxt=itemview.findViewById(R.id.txt6);
            img=itemview.findViewById(R.id.imgBE1);
        }

    }

}
