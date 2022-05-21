
package ch05.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.ToString;

@ToString
public class Torrent {

    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("hash")
    @Expose
    public String hash;
    @SerializedName("quality")
    @Expose
    public String quality;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("seeds")
    @Expose
    public Integer seeds;
    @SerializedName("peers")
    @Expose
    public Integer peers;
    @SerializedName("size")
    @Expose
    public String size;
    @SerializedName("size_bytes")
    @Expose
    public Long sizeBytes;
    @SerializedName("date_uploaded")
    @Expose
    public String dateUploaded;
    @SerializedName("date_uploaded_unix")
    @Expose
    public Integer dateUploadedUnix;

}
