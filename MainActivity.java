package com.example.shubham.jsonapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Temperature> weather= new ArrayList();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL url = NetworkUtil.buildUrlForWeather();
        new FetchWeatherDetails().execute(url);
        listView =findViewById(R.id.lsView);
    }



    private class FetchWeatherDetails extends AsyncTask<URL,Void,String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String weatherSearchResult = null;
            try{
                weatherSearchResult = NetworkUtil.getResponseFromHttpUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("BackGround",weatherSearchResult);
            return weatherSearchResult;
        }

        @Override
        protected  void onPreExecute(){
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String weatherSearchResult) {
            if(weatherSearchResult!=null && !weatherSearchResult.equals("")){
                weather = parseJSON(weatherSearchResult);
               // weather =parseJSON(weatherSearchResult);
            }
            super.onPostExecute(weatherSearchResult);
        }
        private ArrayList<Temperature> parseJSON(String wString){
            if(wString!=null){
                weather.clear();
            }
            if(wString!=null) try {
                JSONObject rootObject = new JSONObject(wString);
                JSONArray results = rootObject.getJSONArray("DailyForecasts");
                for (int i = 0; i < results.length(); i++) {
                    Temperature temp = new Temperature();
                    JSONObject resultObj = results.getJSONObject(i);
                    String date = resultObj.getString("Date");
                    temp.setDate(date);
                    Log.i("date", date);

                    JSONObject tempObj = resultObj.getJSONObject("Temperature");
                    String minTemp = tempObj.getJSONObject("Minimum").getString("Value");
                    String maxTemp = tempObj.getJSONObject("Maximum").getString("Value");
                    Log.i("Temp", minTemp + "," + maxTemp);
                    String Link = resultObj.getString("Link");

                    temp.setMaxTemp(maxTemp);
                    temp.setMinTemp(minTemp);
                    temp.setLink(Link);

                    weather.add(temp);

                }
                if (weather != null) {
                    WeatherAdaptor weatherAdaptor = new WeatherAdaptor(getBaseContext(),weather);
                    listView.setAdapter(weatherAdaptor);
                }
                else{
                    Toast.makeText(MainActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }

                return weather;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return  null;
        }
    }
}
