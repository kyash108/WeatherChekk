package com.example.weatherchekk.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherchekk.pojo.CustomRecycleViewAdapter;
import com.example.weatherchekk.R;
import com.example.weatherchekk.Term;

import java.util.ArrayList;

import static com.example.weatherchekk.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link credits#newInstance} factory method to
 * create an instance of this fragment.
 */
public class credits extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public credits() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment credits.
     */
    // TODO: Rename and change types and number of parameters
    public static credits newInstance(String param1, String param2) {
        credits fragment = new credits();
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
    /**
     * Adding data to the recycler view on the credits page
     * @author - Yash Kumar
     *
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_credits, container, false);
        fab.hide();
        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Term(R.drawable.linkedin, " Picture of- Linkedin Icon \n Photo by:- Freepik \n bit.ly/3lhtvN4"));
        terms.add(new Term(R.drawable.sun, " Picture of- Weather Icon \n Photo by:- Good Ware \n http://bit.ly/2Oo6P1P"));
        terms.add(new Term(R.drawable.communicates, " Picture of- Contact me Icon \n Photo by:- Srip\n http://bit.ly/3rNPbCW"));
        terms.add(new Term(R.drawable.researchs, " Picture of- Credits Icon \n Photo by:- UltimateArm\n https://bit.ly/3bNRUGI"));
        terms.add(new Term(R.drawable.instagrams, " Picture of- Instagram Icon \n Photo by:- Freepik\n https://bit.ly/3bIiNvP"));
        terms.add(new Term(R.drawable.background, " Picture of- Weather Background\n Photo by:- Frédéric Perez\n http://bit.ly/3bYYUkk"));
        terms.add(new Term(R.drawable.backgroundimage, " Picture of- Weather Background\n Photo by:- De Jesus Benitez\n http://bit.ly/3d5YlES"));
        terms.add(new Term(R.drawable.icon, " Picture of- App Icon\n Photo by:- Those Icons\n https://bit.ly/3wsQEkS"));
        terms.add(new Term(R.drawable.rainbg, " Picture of- Background Image\n Photo by:- KAL VISUALS\n https://bit.ly/39Hn2WY"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CustomRecycleViewAdapter(terms,getContext()));

        return view;

    }
}