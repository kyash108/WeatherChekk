package com.example.weatherchekk;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.weatherchekk.pojo.ReminderDatabase;
import com.example.weatherchekk.pojo.reminds;

import static com.example.weatherchekk.MainActivity.fab;

public class createupdates extends Fragment {


    reminds Reminder;
    public static final int UPDATE = 1;
    public static final int CREATE = 2;
    public static final String views = "Project";
    public static final String ACTION_TYPE="action_type";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_createupdates, container, false);
        EditText city = view.findViewById(R.id.editCityName);
        TimePicker timePicker = view.findViewById(R.id.timePicker);

        fab.hide();
        Button submit = view.findViewById(R.id.submit);

        if (getArguments() != null) {
            if (getArguments().getInt(ACTION_TYPE) == UPDATE) {
                Reminder = getArguments().getParcelable(views);
                submit.setText("UPDATE DATA");

                if (Reminder != null) {
                    city.setText(Reminder.getCity());
                    timePicker.setHour(Integer.parseInt(Reminder.getHour()));
                    timePicker.setMinute(Integer.parseInt(Reminder.getMinute()));

                }
            } else {
                Reminder = new reminds();
                submit.setText("CREATE DATA");
            }
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Reminder.setCity(city.getText().toString());
                    Reminder.setHour(String.valueOf(timePicker.getHour()));
                    Reminder.setMinute(String.valueOf(timePicker.getMinute()));
                    int i = Integer.parseInt(Reminder.getHour());
                    if (i>12){
                        Reminder.setAm("PM");
                    }else{
                        Reminder.setAm("AM");
                    }

                    ReminderDatabase db = new ReminderDatabase(getContext());
                    if (getArguments().getInt(ACTION_TYPE) == UPDATE) {
                        db.updateData(Reminder);
                    } else if (getArguments().getInt(ACTION_TYPE) == CREATE) {
                        db.addProject(Reminder);
                    }
                    db.close();
                    Navigation.findNavController(view).popBackStack();
                }
            });
        }


        return view;
    }
}