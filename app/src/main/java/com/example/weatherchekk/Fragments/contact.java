package com.example.weatherchekk.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.weatherchekk.R;

import static com.example.weatherchekk.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contact extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public contact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contact.
     */
    // TODO: Rename and change types and number of parameters
    public static contact newInstance(String param1, String param2) {
        contact fragment = new contact();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        fab.hide();
        Button facebook=view.findViewById(R.id.facebook);
        /**
         * Intent for facebook
         * @author - Yash Kumar
         *
         */

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri facebook = Uri.parse("https://www.facebook.com/kyash108/");
                Intent intent = new Intent(Intent.ACTION_VIEW, facebook);
                startActivity(intent);
            }
        });
        /**
         * Intent for instagram
         * @author - Yash Kumar
         *
         */
        Button instagram = view.findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri profile = Uri.parse("https://www.instagram.com/yashk108/");
                Intent intent = new Intent(Intent.ACTION_VIEW, profile);
                startActivity(intent);
            }
        });
        /**
         * Intent for linkedin
         * @author - Yash Kumar
         *
         */
        Button linkedin = view.findViewById(R.id.linkedin);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri page = Uri.parse("https://www.linkedin.com/in/yash-k-3628b4164/");
                Intent intent = new Intent(Intent.ACTION_VIEW, page);
                startActivity(intent);
            }
        });
        /**
         * Intent for my website
         * @author - Yash Kumar
         *
         */
        Button website = view.findViewById(R.id.website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://ykumar.scweb.ca/");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });
        return view;
    }
}