package com.example.covidinfoactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CovidInfoActivity extends AppCompatActivity {
    TextView cases;

    TextView total_cases;

    TextView recover;

    TextView total_recover;

    TextView deaths;

    TextView total_death;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cases = findViewById(R.id.cases);
        total_cases = findViewById(R.id.total_cases);
        deaths = findViewById(R.id.deaths);
        total_death = findViewById(R.id.total_death);
        recover = findViewById(R.id.recover);
        total_recover = findViewById(R.id.total_recover);

        getAllInfoCovid();
    }

    private void getAllInfoCovid() {

        Call<Covid> callCovid = RetrofitClient.getInstance().myApi().getCovidData();
        callCovid.enqueue(new Callback<Covid>() {
                              public void onResponse(Call<Covid> call, Response<Covid> response) {
                                  Covid covidData = response.body();
                                  printCovidInfo(covidData);
                              }
                              public void onFailure(Call<Covid> call, Throwable t) {
                                  Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                              }


                          }

        );

    }

    private void printCovidInfo(Covid covidData) {
        total_cases.setText(String.valueOf(covidData.getCases()));
        total_death.setText(String.valueOf(covidData.getDeaths()));
        total_recover.setText(String.valueOf(covidData.getRecovered()));
    }

}
