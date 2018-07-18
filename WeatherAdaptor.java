package com.example.shubham.jsonapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdaptor extends ArrayAdapter<Temperature> {
    public WeatherAdaptor(@NonNull Context context, ArrayList<Temperature> weather) {
        super(context, 0, weather);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Temperature weather = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view2, parent, false);
        }

        TextView tvDate = convertView.findViewById(R.id.tvHighTemp);
        TextView tvMin = convertView.findViewById(R.id.tvLowtemp);
        TextView tvTemp = convertView.findViewById(R.id.avTemp);
        TextView tvLink = convertView.findViewById(R.id.tvHttpLink);
        tvDate.setText(weather.getDate());
        tvMin.setText(weather.getMinTemp());
        tvTemp.setText(weather.getMaxTemp());
        tvLink.setText(weather.getLink());
        return convertView;

    }
}
