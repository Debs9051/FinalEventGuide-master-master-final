package events.tcs.com.events.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Arun on 8/1/2017.
 */

public class CacheManager {

    private static HashMap<String, Object> hashMapCache = new HashMap<>();

    public static void saveObjectCache(String key, Object value){
        hashMapCache.put(key,value);
    }

    public static Object readSharedPref(String key){
        return hashMapCache.get(key);
    }
}
