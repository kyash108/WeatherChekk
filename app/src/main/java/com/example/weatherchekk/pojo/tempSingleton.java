package com.example.weatherchekk.pojo;
import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class tempSingleton {
    public static  tempSingleton instance;
    private RequestQueue requestQueue;
    private static Context context;

    private  tempSingleton(Context context){
        this.context = context;
    }

    public static tempSingleton getInstance(Context context) {
        if (instance == null){
            instance = new tempSingleton(context);
        }

        return instance;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue ==  null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
}
