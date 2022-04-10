package com.example.datavid_19;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import com.example.datavid_19.api.ApiUtilities;
import com.example.datavid_19.api.CountryData;

import org.eazegraph.lib.charts.PieChart;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView totalConfirmed, totalDeaths, totalRecovered, totalTested, totalActive, date, casesToday, deathsToday, recoveredToday;
    String country = "India";
//    private ImageView countryFlag;
    private PieChart pieChart;
    private List<CountryData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
//        Data of all the countries will be stored in this list.
// this -
        if (getIntent().getStringExtra("country") != null){
            country = getIntent().getStringExtra("country");
        }
//        this
        init();
//        this-
        TextView cname = findViewById(R.id.countryName);
        cname.setText(country);
//        this  findViewById(R.id.countryName)
        cname.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CountryActivity.class)));
        ApiUtilities.getApiInterface().getCountryData().enqueue(new Callback<List<CountryData>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
//             @RequiresApi(api = Build.VERSION_CODES.N) is written because API level 24 is required and my API level was 21.
            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {
//                This will show the data. 'response' is the data that it receives from the server.
                list.addAll(response.body());
                for (int i = 0; i<list.size(); i++){
                    if (list.get(i).getCountry().equals(country)){
                        int confirm = Integer.parseInt(list.get(i).getCases());
                        int recovered = Integer.parseInt(list.get(i).getRecovered());
                        int active = Integer.parseInt(list.get(i).getActive());
                        int deaths = Integer.parseInt(list.get(i).getDeaths());
//                        int deathsTodayy = Integer.parseInt(list.get(i).getDeathsToday());
//                        int recoveredTodayy = Integer.parseInt(list.get(i).getRecoveredToday());
//                        int casesTodayy = Integer.parseInt(list.get(i).getCasesToday());

                        totalTested.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTests())));
                        totalActive.setText(NumberFormat.getInstance().format(active));
                        totalConfirmed.setText(NumberFormat.getInstance().format(confirm));
                        totalRecovered.setText(NumberFormat.getInstance().format(recovered));
                        totalDeaths.setText(NumberFormat.getInstance().format(deaths));
//                        deathsToday.setText(NumberFormat.getInstance().format(deathsTodayy));
//                        recoveredToday.setText(NumberFormat.getInstance().format(recoveredTodayy));
//                        casesToday.setText(NumberFormat.getInstance().format(casesTodayy));
//                        countryFlag.setImage;

//                        pieChart.addPieSlice(new PieModel("Confirmed", confirm, getResources().getColor(R.color.yellow)));
//                        pieChart.addPieSlice(new PieModel("Active", active, getResources().getColor(R.color.red_pie)));
//                        pieChart.addPieSlice(new PieModel("Recovered", confirm, getResources().getColor(R.color.green_pie)));
//                        pieChart.addPieSlice(new PieModel("Deaths", confirm, getResources().getColor(R.color.blue_pie)));

                        setTime(list.get(i).getUpdated());
//                        This method is created to get the time at which data was updated
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CountryData>> call, Throwable t) {
//                This will tell the user if data can't be retrieved
                Toast.makeText(MainActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void init(){
        totalConfirmed = findViewById(R.id.totalConfirmed);
        totalTested = findViewById(R.id.totalTested);
        totalRecovered = findViewById(R.id.totalRecovered);
        totalDeaths = findViewById(R.id.totalDeaths);
        totalActive = findViewById(R.id.totalActive);
        date = findViewById(R.id.date);
//        casesToday = findViewById(R.id.casesToday);
//        recoveredToday = findViewById(R.id.recoveredToday);
//        deathsToday = findViewById(R.id.deathsToday);
//        countryFlag = findViewById(R.id.countryflag);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setTime(String updated){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            DateFormat format = new SimpleDateFormat("MMM dd, YYYY");
            long milliSeconds = Long.parseLong(updated);
//            Time is received in milliseconds.
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(milliSeconds);
            date.setText("Updated at "+format.format(calendar.getTime()));
        }

    }
}