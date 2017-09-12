package me.elrevin.vkgroupclient.rest.model.responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Full <T> {

    @SerializedName("response")
    @Expose
    public T response;
}
