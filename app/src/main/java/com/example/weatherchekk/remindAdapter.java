package com.example.weatherchekk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherchekk.pojo.reminds;

import java.util.ArrayList;

public class remindAdapter extends RecyclerView.Adapter<remindAdapter.CustomViewHolder> {
    private ArrayList<reminds> reminders;
    private Context context;

    public remindAdapter(ArrayList<reminds> reminders, Context context ){
        this.reminders = reminders;
        this.context = context;
    }

    @NonNull
    @Override
    public remindAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_remind,null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new remindAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        reminds reminds = reminders.get(position);
//        holder.edit.setImageResource(reminds.getEdit());
        holder.hour.setText(reminds.getHour());
        holder.minute.setText(reminds.getMinute());
        holder.am.setText(reminds.getAm());
        holder.city.setText(reminds.getCity());
    }

    @Override
    public int getItemCount() {
        if (reminders != null){
            return reminders.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView edit;
        protected TextView hour;
        protected TextView minute;
        protected TextView am;
        protected TextView city;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
//            this.edit = itemView.findViewById(R.id.edit);
            this.hour = itemView.findViewById(R.id.hour);
            this.minute = itemView.findViewById(R.id.minute);
            this.am = itemView.findViewById(R.id.am);
            this.city = itemView.findViewById(R.id.city);

        }
    }
}
