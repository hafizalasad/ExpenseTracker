package com.hafiz.expensetracker.network.response.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("StatusCode")
    private int statusCode;
    @SerializedName("StatusMessage")
    private String statusMessage;
    @SerializedName("Timestamp")
    private String timestamp;
    @SerializedName("error")
    private String error;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
