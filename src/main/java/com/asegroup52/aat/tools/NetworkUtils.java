package com.asegroup52.aat.tools;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;

public class NetworkUtils {

    private static Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }
}
