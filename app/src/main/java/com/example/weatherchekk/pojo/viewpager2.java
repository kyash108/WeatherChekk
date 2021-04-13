package com.example.weatherchekk.pojo;

import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weatherchekk.R;

import static com.example.weatherchekk.MainActivity.sharedPrefs;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link viewpager2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class viewpager2 extends Fragment {

    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";
    private static final String ARG_PARAM6 = "param6";
    private static final String ARG_PARAM7 = "param7";
    private static final String ARG_PARAM8 = "param8";
    private static final String ARG_PARAM9 = "param9";
    private static final String ARG_PARAM10 = "param10";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String mParam5;
    private String mParam6;
    private String mParam7;
    private String mParam8;
    private String mParam9;
    private String mParam10;


    public viewpager2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment viewpager2.
     */
    // TODO: Rename and change types and number of parameters
    public static viewpager2 newInstance(String param1, String param2, String param3, String param4, String param5,
                                         String param6,String param7,String param8,String param9,String param10) {
        viewpager2 fragment = new viewpager2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM6, param6);
        args.putString(ARG_PARAM7, param7);
        args.putString(ARG_PARAM8, param8);
        args.putString(ARG_PARAM9, param9);
        args.putString(ARG_PARAM10, param10);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            mParam6 = getArguments().getString(ARG_PARAM6);
            mParam7 = getArguments().getString(ARG_PARAM7);
            mParam8 = getArguments().getString(ARG_PARAM8);
            mParam9 = getArguments().getString(ARG_PARAM9);
            mParam10 = getArguments().getString(ARG_PARAM10);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_viewpager2, container, false);
        /**
         * View pager 2 parameters
         * @author - Yash Kumar
         *
         */
        if(mParam1 !=null) {
            TextView cityNameHome = view.findViewById(R.id.cityNameHome);
            cityNameHome.setText(mParam1);
        }
        if(mParam2 !=null) {
            TextView desc = view.findViewById(R.id.desc);
            desc.setText(mParam2);
        }
        if(mParam3 !=null) {
            TextView pressure = view.findViewById(R.id.pressure);
            pressure.setText(mParam3);
        }
        if(mParam4 !=null) {
            TextView wind = view.findViewById(R.id.wind);
            wind.setText(mParam4);
        }
        if(mParam5 !=null) {
            TextView temp = view.findViewById(R.id.temp);
            temp.setText(mParam5);
        }
        if(mParam6 !=null) {
            TextView low = view.findViewById(R.id.low);
            low.setText(mParam6);
        }
        if(mParam7 !=null) {
            TextView high = view.findViewById(R.id.high);
            high.setText(mParam7);
        }
        if(mParam8 !=null) {
            TextView feelslike = view.findViewById(R.id.feelslike);
            feelslike.setText(mParam8);
        }
        if(mParam9 !=null) {
            TextView visibility = view.findViewById(R.id.visibility);
            visibility.setText(mParam9);
        }
        if(mParam10 !=null) {
            TextView humidity = view.findViewById(R.id.humidity);
            humidity.setText(mParam10);
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView cityNameHome = view.findViewById(R.id.cityNameHome);
        TextView desc = view.findViewById(R.id.desc);
        TextView pressure = view.findViewById(R.id.pressure);
        TextView wind = view.findViewById(R.id.wind);
        TextView temp = view.findViewById(R.id.temp);
        TextView low = view.findViewById(R.id.low);
        TextView high = view.findViewById(R.id.high);
        TextView feelslike = view.findViewById(R.id.feelslike);
        TextView visibility = view.findViewById(R.id.visibility);
        TextView humidity = view.findViewById(R.id.humidity);
        /**
         * Adjusting the font size
         * @author - Yash Kumar
         *
         */
        String fontSizeChoice = sharedPrefs.getString("fontSize", "20sp");
        switch (fontSizeChoice) {
            case "18sp":
                cityNameHome.setTextSize(18);
                desc.setTextSize(18);
                pressure.setTextSize(18);
                wind.setTextSize(18);
                temp.setTextSize(18);
                low.setTextSize(18);
                high.setTextSize(18);
                feelslike.setTextSize(18);
                visibility.setTextSize(18);
                humidity.setTextSize(18);
                break;
            case "20sp":
                cityNameHome.setTextSize(20);
                desc.setTextSize(20);
                pressure.setTextSize(20);
                wind.setTextSize(20);
                temp.setTextSize(20);
                low.setTextSize(20);
                high.setTextSize(20);
                feelslike.setTextSize(20);
                visibility.setTextSize(20);
                humidity.setTextSize(20);
                break;
            case "24sp":
                cityNameHome.setTextSize(24);
                desc.setTextSize(24);
                pressure.setTextSize(24);
                wind.setTextSize(24);
                temp.setTextSize(24);
                low.setTextSize(24);
                high.setTextSize(24);
                feelslike.setTextSize(24);
                visibility.setTextSize(24);
                humidity.setTextSize(24);
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
                cityNameHome.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                desc.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                pressure.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                wind.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                temp.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                low.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                high.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                feelslike.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                visibility.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                humidity.setTypeface(ResourcesCompat.getFont(getContext(), R.font.inder));
                break;
            case "Cagliostro":
                cityNameHome.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                desc.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                pressure.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                wind.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                temp.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                low.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                high.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                feelslike.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                visibility.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                humidity.setTypeface(ResourcesCompat.getFont(getContext(), R.font.cagliostro));
                break;
            case "Ledger":
                cityNameHome.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                desc.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                pressure.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                wind.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                temp.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                low.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                high.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                feelslike.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                visibility.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                humidity.setTypeface(ResourcesCompat.getFont(getContext(), R.font.ledger));
                break;

        }
    }
}