package jrml.supinternet.com.jeredecouvremalangue.feature.notification;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;
import java.util.TimeZone;

public class MyApplication extends Application {
    public MyApplication(){
        Log.d("JS\\", "MyApplication is running!: ");
    }

    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
        setRecurringAlarm(context);
    }

    private void setRecurringAlarm(Context context) {

        // we know mobiletuts updates at right around 1130 GMT.
        // let's grab new stuff at around 11:45 GMT, inexactly
        Calendar updateTime = Calendar.getInstance();
        updateTime.setTimeZone(TimeZone.getTimeZone("GMT"));
        updateTime.set(Calendar.HOUR_OF_DAY, 11);
        updateTime.set(Calendar.MINUTE, 5);

        Intent notification = new Intent(context, NotificationReceiver.class);
        PendingIntent recurringNotification = PendingIntent.getBroadcast(context,
                0, notification, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarms = (AlarmManager) getSystemService(
                Context.ALARM_SERVICE);
        alarms.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                updateTime.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, recurringNotification);
    }
}
