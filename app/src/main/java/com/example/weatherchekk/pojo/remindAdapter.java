package com.example.weatherchekk.pojo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherchekk.Fragments.createupdates;
import com.example.weatherchekk.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.weatherchekk.MainActivity.currentTime;
import static com.example.weatherchekk.MainActivity.sharedPrefs;

public class remindAdapter extends RecyclerView.Adapter<remindAdapter.CustomViewHolder> {
    private ArrayList<reminds> reminders;
    private Context context;
    public static String currentH;
    public static String currentM;
    public static String currentP;

    public remindAdapter(ArrayList<reminds> reminders, Context context ){
        this.reminders = reminders;
        this.context = context;
    }

    @NonNull
    @Override
    public remindAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_remind, null);
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

        String currentH = reminders.get(reminders.lastIndexOf(reminds)).getHour();
        String currentM = reminders.get(reminders.lastIndexOf(reminds)).getMinute();
        String currentP = reminders.get(reminders.lastIndexOf(reminds)).getAm();

        String stringAlarm = currentH+":"+currentM+currentP;
        /**
         * Setting alarm according the current time
         * @author - Yash Kumar
         *
         */

        Ringtone r = RingtoneManager.getRingtone(context,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(currentTime.equals(stringAlarm)){
                    r.play();
                }else if(!currentTime.equals(stringAlarm)) {
                    r.stop();
                }
            }
        },0,1000);
        /**
         * edit button to edit a reminder
         * @author - Yash Kumar
         *
         */
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
        protected TextView dot;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.hour = itemView.findViewById(R.id.hour);
            this.minute = itemView.findViewById(R.id.minute);
            this.am = itemView.findViewById(R.id.am);
            this.city = itemView.findViewById(R.id.city);
            this.edit = itemView.findViewById(R.id.edit);
            this.dot = itemView.findViewById(R.id.dot);
            itemView.setOnClickListener(this);
            /**
             * Adjusting the font size
             * @author - Yash Kumar
             *
             */
            String fontSizeChoice = sharedPrefs.getString("fontSize","18sp");
            switch (fontSizeChoice){
                case "18sp" :
                    hour.setTextSize(18);
                    minute.setTextSize(18);
                    am.setTextSize(18);
                    city.setTextSize(18);
                    dot.setTextSize(18);
                    break;
                case "20sp" :
                    hour.setTextSize(20);
                    minute.setTextSize(20);
                    am.setTextSize(20);
                    city.setTextSize(20);
                    dot.setTextSize(20);
                    break;
                case "24sp" :
                    hour.setTextSize(24);
                    minute.setTextSize(24);
                    am.setTextSize(24);
                    city.setTextSize(24);
                    dot.setTextSize(24);
                    break;
            }
            /**
             * Adjusting the font family
             * @author - Yash Kumar
             *
             */
            String fontFamily = sharedPrefs.getString("fontStyle", "Inder");
            switch (fontFamily) {
                case "Inder":
                    hour.setTypeface(ResourcesCompat.getFont(context, R.font.inder));
                    minute.setTypeface(ResourcesCompat.getFont(context, R.font.inder));
                    am.setTypeface(ResourcesCompat.getFont(context, R.font.inder));
                    city.setTypeface(ResourcesCompat.getFont(context, R.font.inder));
                    dot.setTypeface(ResourcesCompat.getFont(context, R.font.inder));
                    break;
                case "Cagliostro":
                    hour.setTypeface(ResourcesCompat.getFont(context, R.font.cagliostro));
                    minute.setTypeface(ResourcesCompat.getFont(context, R.font.cagliostro));
                    am.setTypeface(ResourcesCompat.getFont(context, R.font.cagliostro));
                    city.setTypeface(ResourcesCompat.getFont(context, R.font.cagliostro));
                    dot.setTypeface(ResourcesCompat.getFont(context, R.font.cagliostro));
                    break;
                case "Ledger":
                    hour.setTypeface(ResourcesCompat.getFont(context, R.font.ledger));
                    minute.setTypeface(ResourcesCompat.getFont(context, R.font.ledger));
                    am.setTypeface(ResourcesCompat.getFont(context, R.font.ledger));
                    city.setTypeface(ResourcesCompat.getFont(context, R.font.ledger));
                    dot.setTypeface(ResourcesCompat.getFont(context, R.font.ledger));
                    break;

            }
//
//            ConstraintLayout rl = itemView.findViewById(R.id.cardViewCon);
//            ConstraintLayout rk = itemView.findViewById(R.id.timeLayout);
//            sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
//            boolean background = sharedPrefs.getBoolean("backgroundImage",false);
//            if (background){
//                rl.setBackgroundColor(ContextCompat.getColor(context, R.color.orangeprimary));
//                rk.setBackgroundColor(ContextCompat.getColor(context, R.color.orangeprimary));
//            }else{
//            rl.setBackgroundColor(ContextCompat.getColor(context, R.color.greenprimary));
//            rk.setBackgroundColor(ContextCompat.getColor(context, R.color.greenprimary));
//            }
        }

        /**
         * On click listener to delete a reminder from the table
         * @author - Yash Kumar
         *
         */
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
