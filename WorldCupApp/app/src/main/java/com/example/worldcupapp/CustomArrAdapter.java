/*
#       Written by : Rose (Pratama Azmi A)
#       Date : Unknown 
#       Text editor : AndroidStudio + VIM
*/
package com.example.worldcupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.function.Function;

public class CustomArrAdapter extends ArrayAdapter<CountryModel> {

    private Context context;
    private List<CountryModel> listObjects ;

    public Function<CountryModel, View.OnClickListener> clickListener;

    public CustomArrAdapter(@NonNull Context context, @NonNull List<CountryModel> objects) {
        super(context, R.layout.item_list_activity_main, objects);
        this.context = context;
        this.listObjects = objects;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public List<CountryModel> getListObjects() {
        return listObjects;
    }

    static class ViewHolder
    {
        TextView countryName;
        ImageView countryImage;
        TextView countryWins;

        void bind(Context context, CountryModel data)
        {
            countryImage.setImageDrawable(context.getDrawable(data.getCountryImage()));
            countryName.setText(""+data.getCountryName());
            countryWins.setText("" +data.getCountryWins());
        }
    }

    @Nullable
    @Override
    public CountryModel getItem(int position) {
        return listObjects.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CountryModel currentCountry = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_list_activity_main, parent, false);

            viewHolder.countryName =  view.findViewById(R.id.tv_countryName);
            viewHolder.countryWins = view.findViewById(R.id.tv_countryWins);
            viewHolder.countryImage = view.findViewById(R.id.iv_countryImage);

            convertView = view;
            convertView.setTag(convertView);
            convertView.setOnClickListener(this.clickListener.apply(currentCountry));

        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.bind(context,currentCountry);

        return convertView;
    }
}
