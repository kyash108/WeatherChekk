package com.example.weatherchekk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherchekk.pojo.ReminderDatabase;
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
        holder.hour.setText(reminds.getHour());
        holder.minute.setText(reminds.getMinute());
        holder.am.setText(reminds.getAm());
        holder.city.setText(reminds.getCity());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extra = new Bundle();
                extra.putInt(createupdates.ACTION_TYPE,createupdates.UPDATE);
                extra.putParcelable(createupdates.views, (Parcelable) reminders.get(position));
                Navigation.findNavController(v).navigate(R.id.createupdates,extra);
            }
        });
    }

    @Override
    public int getItemCount() {
            return reminders.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView edit;
        protected TextView hour;
        protected TextView minute;
        protected TextView am;
        protected TextView city;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.hour = itemView.findViewById(R.id.hour);
            this.minute = itemView.findViewById(R.id.minute);
            this.am = itemView.findViewById(R.id.am);
            this.city = itemView.findViewById(R.id.city);
            this.edit = itemView.findViewById(R.id.edit);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            new AlertDialog.Builder(context).setTitle("Delete").setMessage("Are you sure you want to delete the reminder ?").setIcon(android.R.drawable.ic_dialog_alert).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ReminderDatabase db = new ReminderDatabase(context);
                    db.deleteProject(reminders.get(getLayoutPosition()).getId());
                    reminders.remove(getLayoutPosition());
                    notifyItemRemoved(getAdapterPosition());
                    db.close();
                }
            })
                    .setNegativeButton("No", null)
                    .show();
        }
    }
}
