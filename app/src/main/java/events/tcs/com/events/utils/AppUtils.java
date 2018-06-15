package events.tcs.com.events.utils;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import events.tcs.com.events.R;
import events.tcs.com.events.service.AlarmReceiver;

/**
 * Created by arun on 6/10/2018.
 */

public class AppUtils {
    public static void scheduleNotification(Notification notification, String time, Activity mActivity) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd h:mm a");
            Date date = null;
            date = sdf.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, -1);
            long futureTimeInMillis = calendar.getTime().getTime();
            Date currentDate = Calendar.getInstance().getTime();
            long currentTime = currentDate.getTime();

            if (currentTime > futureTimeInMillis) {
                Toast.makeText(mActivity, "Event already passed", Toast.LENGTH_LONG).show();
            } else {
                long timeforNotification = SystemClock.elapsedRealtime() + (futureTimeInMillis - currentTime);
                Intent notificationIntent = new Intent(mActivity, AlarmReceiver.class);
                notificationIntent.putExtra(AlarmReceiver.NOTIFICATION_ID, 1);
                notificationIntent.putExtra(AlarmReceiver.NOTIFICATION, notification);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(mActivity, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) mActivity.getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, timeforNotification, pendingIntent);
                Toast.makeText(mActivity, "Reminder set successfully, We will remind you 5 minutes before", Toast.LENGTH_LONG).show();
            }
        } catch (ParseException e) {
            Toast.makeText(mActivity, "Error parsing future time", Toast.LENGTH_LONG).show();
        }
    }

    public static Notification getNotification(String title, String content, Activity mActivity) {
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mActivity.getBaseContext(), "")
                .setSmallIcon(R.drawable.ic_launcher_notify)
                .setColor(mActivity.getResources().getColor(R.color.colorWhite))
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(content))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(alarmSound);
        return mBuilder.build();
    }
}
