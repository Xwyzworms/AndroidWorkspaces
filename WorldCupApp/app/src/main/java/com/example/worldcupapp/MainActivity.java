package com.example.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.worldcupapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupListView();
    }
    private void setupListView()
    {
        CustomArrAdapter adapter = new CustomArrAdapter(this,getData());
        binding.listView.setAdapter(adapter);
        adapter.clickListener =this::setAdapterOnClickListener;
    }

    private List<CountryModel> getData()
    {
        ArrayList<CountryModel> countries = new ArrayList<CountryModel>();
        CountryModel brazil = new CountryModel("Brazil", 5, R.drawable.brazil );
        CountryModel france = new CountryModel("France", 1, R.drawable.france);
        CountryModel germany = new CountryModel("Germany", 6, R.drawable.germany);
        CountryModel saudi = new CountryModel("Saudi", 2, R.drawable.saudiarabia);
        CountryModel usa = new CountryModel("United States America", 10, R.drawable.unitedstates);
        CountryModel uk = new CountryModel("United Kingdom", 4, R.drawable.unitedkingdom);

        countries.add(brazil);
        countries.add(germany);
        countries.add(france);
        countries.add(saudi);
        countries.add(usa);
        countries.add(uk);

        return countries;

    }

    private View.OnClickListener setAdapterOnClickListener(CountryModel data)
    {
        View.OnClickListener listener = v -> Toast.makeText(v.getContext(), data.toString(), Toast.LENGTH_LONG).show();

        return  listener;
    }
}