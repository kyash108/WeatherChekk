package com.example.weatherchekk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherchekk.pojo.reminds;

import java.util.ArrayList;

import static com.example.weatherchekk.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link reminder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class reminder extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public reminder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment reminder.
     */
    // TODO: Rename and change types and number of parameters
    public static reminder newInstance(String param1, String param2) {
        reminder fragment = new reminder();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reminder, container, false);

        fab.show();
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle extra = new Bundle();
//                extra.putInt(createUpdateFragment.ACTION_TYPE, createUpdateFragment.CREATE);
//                Navigation.findNavController(view).navigate(R.id.createUpdateFragment,extra);
//            }
//        });

        ArrayList<reminds> reminders = new ArrayList<>();
        reminders.add(new reminds("11","10","AM","Windsor",""));
        reminders.add(new reminds("10","09","PM","Toronto",""));
        reminders.add(new reminds("02","09","PM","Toronto",""));

        RecyclerView recyclerView = view.findViewById(R.id.firstRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new remindAdapter(reminders,getContext()));


        return view;
    }
}