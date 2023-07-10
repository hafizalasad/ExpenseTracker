package com.hafiz.expensetracker.network.response;

import com.google.gson.annotations.SerializedName;
import com.hafiz.expensetracker.network.response.base.BaseResponse;

public class MyIpDetailsResponse extends BaseResponse {

    @SerializedName("ip")
    private String ip;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
