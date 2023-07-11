package com.hafiz.expensetracker.network.retrofitService;

import com.hafiz.expensetracker.network.response.MyIpDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Mahim
 * @since 4/9/20 11:00 AM
 */
public interface MyIpService {

    @GET("/json")
    Call<MyIpDetailsResponse> getDetails();
}
