package com.example.weatherchekk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.weatherchekk.pojo.reminds;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.example.weatherchekk.MainActivity.fab;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {
    ViewPager2 newViewPager;
    String cityWindsor = "Windsor";
    String cityToronto = "Toronto";
    String city="";
    String apiKey = "b22d2146812e4f4143b2462365bd3706";
    double temperature;
    double temperatureMin;
    double temperatureMax;
    int sunrise;
    int sunset;
    double wind;
    double feelslike;
    double visibility;
    double humidity;


    double temperatureW;
    double temperatureMinW;
    double temperatureMaxW;
    int sunriseW;
    int sunsetW;
    double windW;
    double feelslikeW;
    double visibilityW;
    double humidityW;


    double temperatureT;
    double temperatureMinT;
    double temperatureMaxT;
    int sunriseT;
    int sunsetT;
    double windT;
    double feelslikeT;
    double visibilityT;
    double humidityT;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fab.hide();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        newViewPager = view.findViewById(R.id.viewPager2);
        newViewPager.setPageTransformer(new ZoomOutPageTransformer());
        EditText search;
        search = view.findViewById(R.id.search);

        String url = "https://api.openweathermap.org/data/2.5/weather?q="+ cityWindsor +"&units=metric&appid="+apiKey;
        String urlW = "https://api.openweathermap.org/data/2.5/weather?q="+ cityWindsor +"&units=metric&appid="+apiKey;
        String urlT = "https://api.openweathermap.org/data/2.5/weather?q="+ cityToronto +"&units=metric&appid="+apiKey;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject mainObj = response.getJSONObject("main");
                    temperature = mainObj.getInt("temp");
                    temperatureMin = mainObj.getInt("temp_min");
                    temperatureMax = mainObj.getInt("temp_max");
                    humidity = mainObj.getInt("humidity");
                    feelslike = mainObj.getInt("feels_like");

                    JSONObject ss = response.getJSONObject("sys");
                    sunrise = ss.getInt("sunrise");
                    sunset = ss.getInt("sunset");

                    JSONObject winds = response.getJSONObject("wind");
                    wind = winds.getDouble("speed");

                    visibility = response.getDouble("visibility");

//                    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy a");
//                    format.setTimeZone(TimeZone.getTimeZone("GMT"));
//                    Log.d("date", format.format(date));

                    newViewPager.setAdapter(new CustomerViewPager2Adapter(getActivity()));


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




        JsonObjectRequest requestW = new JsonObjectRequest(Request.Method.GET, urlW, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject mainObj = response.getJSONObject("main");
                    temperatureW = mainObj.getInt("temp");
                    temperatureMinW = mainObj.getInt("temp_min");
                    temperatureMaxW = mainObj.getInt("temp_max");
                    humidityW = mainObj.getInt("humidity");
                    feelslikeW = mainObj.getInt("feels_like");

                    JSONObject ss = response.getJSONObject("sys");
                    sunriseW = ss.getInt("sunrise");
                    sunsetW = ss.getInt("sunset");

                    JSONObject winds = response.getJSONObject("wind");
                    windW = winds.getDouble("speed");

                    visibilityW = response.getDouble("visibility");

//                    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy a");
//                    format.setTimeZone(TimeZone.getTimeZone("GMT"));
//                    Log.d("date", format.format(date));

                    newViewPager.setAdapter(new CustomerViewPager2Adapter(getActivity()));


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
                    JSONObject mainObj = response.getJSONObject("main");
                    temperatureT = mainObj.getInt("temp");
                    temperatureMinT = mainObj.getInt("temp_min");
                    temperatureMaxT = mainObj.getInt("temp_max");
                    humidityT = mainObj.getInt("humidity");
                    feelslikeT = mainObj.getInt("feels_like");

                    JSONObject ss = response.getJSONObject("sys");
                    sunriseT = ss.getInt("sunrise");
                    sunsetT = ss.getInt("sunset");

                    JSONObject winds = response.getJSONObject("wind");
                    windT = winds.getDouble("speed");

                    visibilityT = response.getDouble("visibility");

//                    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy a");
//                    format.setTimeZone(TimeZone.getTimeZone("GMT"));
//                    Log.d("date", format.format(date));

                    newViewPager.setAdapter(new CustomerViewPager2Adapter(getActivity()));


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

    private class CustomerViewPager2Adapter extends FragmentStateAdapter {

        public CustomerViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
//                return viewpager2.newInstance("City","Sunrise","Sunset","Wind","Temp","Low","High","Feels Like","Visibility","UV");

                case 0:
                    return viewpager2.newInstance(cityWindsor,"Sunrise\n"+sunrise,"Sunset\n"+sunset,"Wind\n"+wind,temperature+"\u2103","L"+temperatureMin+"\u2103", "H"+temperatureMax+"\u2103","Feels Like\n"+feelslike+"\u2103","Visibility\n"+visibility,"Humidity\n"+humidity);
                case 1:
                    return viewpager2.newInstance(cityWindsor,"Sunrise\n"+sunriseW,"Sunset\n"+sunsetW,"Wind\n"+windW,temperatureW+"\u2103","L"+temperatureMinW+"\u2103", "H"+temperatureMaxW+"\u2103","Feels Like\n"+feelslikeW+"\u2103","Visibility\n"+visibilityW,"Humidity\n"+humidityW);
                case 2:
                    return viewpager2.newInstance(cityToronto,"Sunrise\n"+sunriseT,"Sunset\n"+sunsetT,"Wind\n"+windT,temperatureT+"\u2103","L"+temperatureMinT+"\u2103", "H"+temperatureMaxT+"\u2103","Feels Like\n"+feelslikeT+"\u2103","Visibility\n"+visibilityT,"Humidity\n"+humidityT);
                default:
                    return viewpager2.newInstance("Windsor","6:30 AM","6:30Pm","NW 30Km/hr",temperature+"\u2103",temperatureMin+"\u2103","7 \u2103","8 \u2103","16 KM","15");
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }


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