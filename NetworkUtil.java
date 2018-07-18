package com.example.shubham.jsonapp;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtil {
    private final static String WEATHER_BASE_URL="http://dataservice.accuweather.com/forecasts/v1/daily/5day/202396";
    private final static String API_KEY = "PK3FYpLBdd8xJDcvBNs7G4xCR9rFIwFG";//	PK3FYpLBdd8xJDcvBNs7G4xCR9rFIwFG
    private final static String PARAM_API_KEY="apikey";

    public static URL buildUrlForWeather()
    {
        Uri builtUri = Uri.parse(WEATHER_BASE_URL).buildUpon().appendQueryParameter(PARAM_API_KEY,API_KEY).build();
        URL url=null;
        try {
            url=new URL(builtUri.toString());
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        Log.i("Tag","url="+url);
        return url;
    }
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scan = new Scanner(in);
            scan.useDelimiter("\\A");
            boolean hasInput = scan.hasNext();
            if (hasInput) {
                return scan.next();
            } else {
                return null;
            }
        } finally{
            urlConnection.disconnect();
        }
    }

}
