package com.example.weatherchekk.Fragments;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.weatherchekk.R;
import com.example.weatherchekk.pojo.tempSingleton;
import com.example.weatherchekk.pojo.viewpager2;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.weatherchekk.MainActivity.fab;
import static com.example.weatherchekk.MainActivity.sharedPrefs;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {

    /**
     * Variables for the view pager
     * @author - Yash Kumar
     *
     */
    View view;
    ViewPager2 newViewPager;
    String cityWindsor = "Windsor";
    String cityToronto = "Toronto";
    String city="--";
    String apiKey = "b22d2146812e4f4143b2462365bd3706";

    double temperature = 0.0;
    double temperatureMin = 0.0;
    double temperatureMax = 0.0;
    String desc = "--";
    int pressure = 0;
    double wind = 0.0;
    double feelslike = 0.0;
    double visibility = 0.0;
    double humidity = 0.0;


    double temperatureW = 0.0;
    double temperatureMinW = 0.0;
    double temperatureMaxW = 0.0;
    String descW = "--";
    int pressureW = 0;
    double windW = 0.0;
    double feelslikeW = 0.0;
    double visibilityW = 0.0;
    double humidityW = 0.0;


    double temperatureT = 0.0;
    double temperatureMinT = 0.0;
    double temperatureMaxT = 0.0;
    String descT = "--";
    int pressureT = 0;
    double windT = 0.0;
    double feelslikeT = 0.0;
    double visibilityT = 0.0;
    double humidityT = 0.0;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
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
    public void onResume() {
        super.onResume();
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean background = sharedPrefs.getBoolean("backgroundImage",false);

        /**
         * Setting background image using shared preference
         * @author - Yash Kumar
         *
         */
        if (background){
            view.setBackgroundResource(R.drawable.backgroundimage);
//            AppCompatDelegate
//                    .setDefaultNightMode(
//                            AppCompatDelegate
//                                    .MODE_NIGHT_YES);
        }else{
            view.setBackgroundResource(R.drawable.rainbg);
//            AppCompatDelegate
//                    .setDefaultNightMode(
//                            AppCompatDelegate
//                                    .MODE_NIGHT_NO);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fab.hide();
        view = inflater.inflate(R.layout.fragment_home, container, false);
        newViewPager = view.findViewById(R.id.viewPager2);
        newViewPager.setPageTransformer(new ZoomOutPageTransformer());
        EditText search;
        search = view.findViewById(R.id.search);
        /**
         * Search button to search a city's wearther
         * @author - Yash Kumar
         *
         */
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    city = search.getText().toString();
                    requestPage(view);
                }
                search.getText().clear();
                return false;
            }
        });


        String urlW = "https://api.openweathermap.org/data/2.5/weather?q="+ cityWindsor +"&units=metric&appid="+apiKey;
        String urlT = "https://api.openweathermap.org/data/2.5/weather?q="+ cityToronto +"&units=metric&appid="+apiKey;

        /**
         * JSON request for first city
         * @author - Yash Kumar
         *
         */
        JsonObjectRequest requestW = new JsonObjectRequest(Request.Method.GET, urlW, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    /**
                     * Assigning values to the variable from the JSON data received
                     * @author - Yash Kumar
                     *
                     */
                    JSONObject mainObj = response.getJSONObject("main");
                    temperatureW = mainObj.getDouble("temp");
                    temperatureMinW = mainObj.getDouble("temp_min");
                    temperatureMaxW = mainObj.getDouble("temp_max");
                    humidityW = mainObj.getDouble("humidity");
                    feelslikeW = mainObj.getDouble("feels_like");

                    pressureW = mainObj.getInt("pressure");

                    String descriptionW = null;
                    JSONArray weathers = response.getJSONArray("weather");
                    for (int i = 0; i < weathers.length(); i++) {
                        JSONObject c = weathers.getJSONObject(i);
                        descriptionW = c.getString("description");
                    }
                    descW = descriptionW.substring(0, 1).toUpperCase() + descriptionW.substring(1).toLowerCase();

                    JSONObject winds = response.getJSONObject("wind");
                    windW = winds.getDouble("speed");

                    visibilityW = response.getDouble("visibility");
                    visibilityW = visibilityW/1000;

                    newViewPager.setAdapter(new CustomViewPager2Adapter(getActivity()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(view, error.toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tempSingleton.getInstance(getContext()).getRequestQueue().add(requestW);



        JsonObjectRequest requestT = new JsonObjectRequest(Request.Method.GET, urlT, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    /**
                     * Assigning values to the variable from the JSON data received
                     * @author - Yash Kumar
                     *
                     */
                    JSONObject mainObj = response.getJSONObject("main");
                    temperatureT = mainObj.getDouble("temp");
                    temperatureMinT = mainObj.getDouble("temp_min");
                    temperatureMaxT = mainObj.getDouble("temp_max");
                    humidityT = mainObj.getDouble("humidity");
                    feelslikeT = mainObj.getDouble("feels_like");

                    pressureT = mainObj.getInt("pressure");

                    String descriptionT=null;
                   JSONArray weathers = response.getJSONArray("weather");
                    for (int i = 0; i < weathers.length(); i++) {
                        JSONObject c = weathers.getJSONObject(i);
                        descriptionT = c.getString("description");
                    }
                    descT = descriptionT.substring(0, 1).toUpperCase() + descriptionT.substring(1).toLowerCase();

                    JSONObject winds = response.getJSONObject("wind");
                    windT = winds.getDouble("speed");

                    visibilityT = response.getDouble("visibility");
                    visibilityT = visibilityT/1000;

                    newViewPager.setAdapter(new CustomViewPager2Adapter(getActivity()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(view, error.toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tempSingleton.getInstance(getContext()).getRequestQueue().add(requestT);

        return view;
    }

    public void requestPage(View view){

        String url = "https://api.openweathermap.org/data/2.5/weather?q="+ city +"&units=metric&appid="+apiKey;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    /**
                     * Assigning values to the variable from the JSON data received
                     * @author - Yash Kumar
                     *
                     */
                    JSONObject mainObj = response.getJSONObject("main");
                    temperature = mainObj.getDouble("temp");
                    temperatureMin = mainObj.getDouble("temp_min");
                    temperatureMax = mainObj.getDouble("temp_max");
                    humidity = mainObj.getDouble("humidity");
                    feelslike = mainObj.getDouble("feels_like");
                    pressure = mainObj.getInt("pressure");

                    city = response.getString("name");

                    String description=null;
                    JSONArray weathers = response.getJSONArray("weather");
                    for (int i = 0; i < weathers.length(); i++) {
                        JSONObject c = weathers.getJSONObject(i);
                        description = c.getString("description");
                    }
                    desc = description.substring(0, 1).toUpperCase() + description.substring(1).toLowerCase();

                    JSONObject winds = response.getJSONObject("wind");
                    wind = winds.getDouble("speed");

                    visibility = response.getDouble("visibility");
                    visibility = visibility/1000;

                    newViewPager.setAdapter(new CustomViewPager2Adapter(getActivity()));

                    newViewPager.getAdapter().notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(view, error.toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        tempSingleton.getInstance(getContext()).getRequestQueue().add(request);

    }

    private class CustomViewPager2Adapter extends FragmentStateAdapter {

        public CustomViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
//                return viewpager2.newInstance("City","Sunrise","Sunset","Wind","Temp","Low","High","Feels Like","Visibility","UV");
                /**
                 * Adding values to the view pager from the JSON request
                 * @author - Yash Kumar
                 *
                 */
                case 0:
                    return viewpager2.newInstance(city,"Description\n"+desc,"Pressure\n"+pressure,"Wind\n"+wind+"m/sec",temperature+"\u2103","L "+temperatureMin+"\u2103", "H "+temperatureMax+"\u2103","Feels Like\n"+feelslike+"\u2103","Visibility\n"+visibility+"Km","Humidity\n"+humidity+"%");
                case 1:
                    return viewpager2.newInstance(cityWindsor,"Description\n"+descW,"Pressure\n"+pressureW,"Wind\n"+windW+"m/sec",temperatureW+"\u2103","L "+temperatureMinW+"\u2103", "H "+temperatureMaxW+"\u2103","Feels Like\n"+feelslikeW+"\u2103","Visibility\n"+visibilityW+"Km","Humidity\n"+humidityW+"%");
                case 2:
                    return viewpager2.newInstance(cityToronto,"Description\n"+descT,"Pressure\n"+pressureT,"Wind\n"+windT+"m/sec",temperatureT+"\u2103","L "+temperatureMinT+"\u2103", "H "+temperatureMaxT+"\u2103","Feels Like\n"+feelslikeT+"\u2103","Visibility\n"+visibilityT+"Km","Humidity\n"+humidityT+"%");
                default:
                    return viewpager2.newInstance("Windsor","6:30 AM","6:30Pm","NW 30Km/hr",temperature+"\u2103",temperatureMin+"\u2103","7 \u2103","8 \u2103","16 KM","15%");
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }

    /**
     * Animation for the card view on reminders page
     * @author - Yash Kumar
     *
     */
    public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

}