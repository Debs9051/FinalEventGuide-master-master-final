package events.tcs.com.events.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Arun on 7/30/2017.
 */

public class SharedPreferencesManager {

    public static void saveSharedPref(Activity activity, String key, String value){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String readSharedPref(Activity activity, String key){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        return preferences.getString(key, "");
    }
}
