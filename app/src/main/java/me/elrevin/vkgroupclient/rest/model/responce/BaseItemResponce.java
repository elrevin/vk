package me.elrevin.vkgroupclient.rest.model.responce;

import java.util.ArrayList;
import java.util.List;

public class BaseItemResponce <T> {
    public int count;
    public List<T> items = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}
