package com.hafiz.expensetracker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hafiz.expensetracker.network.manager.RetrofitApiClient;
import com.hafiz.expensetracker.network.response.MyIpDetailsResponse;
import com.hafiz.expensetracker.network.retrofitService.MyIpService;
import com.hafiz.expensetracker.ui.base.BaseActionBarActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends BaseActionBarActivity {

    private TextView ipAddressTextView;
    private TextView cityTextView;
    private TextView countryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViewReference() {

        ipAddressTextView = findViewById(R.id.tv_ip_address);
        cityTextView = findViewById(R.id.tv_city);
        countryTextView = findViewById(R.id.tv_country);
    }

    @Override
    protected void initRequest() {

        showMyIpApiCall();
    }

    public void showMyIpApiCall() {

        Retrofit retrofit = RetrofitApiClient.getClient();

        MyIpService apiInterface = retrofit.create(MyIpService.class);

        Call<MyIpDetailsResponse> call = apiInterface.getDetails();
        call.enqueue(new Callback<MyIpDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<MyIpDetailsResponse> call, @NonNull Response<MyIpDetailsResponse> response) {

                MyIpDetailsResponse serverResponse = response.body();

                if (response.code() == 200 && serverResponse != null) { //response code 200 means server call successful
                    //data found. So place the data into TextView
                    ipAddressTextView.setText(serverResponse.getIp());
                    cityTextView.setText(serverResponse.getCity() + ", ");
                    countryTextView.setText(serverResponse.getCountry());
                } else {
                    //somehow data not found. So error message showing in first TextView
                    ipAddressTextView.setText(response.message());
                    cityTextView.setText("");
                    countryTextView.setText("");
                }
            }

            @Override
            public void onFailure(@NonNull Call<MyIpDetailsResponse> call, @NonNull Throwable t) {

                ipAddressTextView.setText(t.getMessage());
                cityTextView.setText("");
                countryTextView.setText("");
            }
        });
    }
}