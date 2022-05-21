package ch05.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.ToString;

@ToString
public class Example {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("status_message")
    @Expose
    public String statusMessage;
    @SerializedName("data")
    @Expose
    public Data data;

}
