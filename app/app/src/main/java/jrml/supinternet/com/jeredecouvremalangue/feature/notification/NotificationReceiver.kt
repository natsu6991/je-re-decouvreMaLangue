package jrml.supinternet.com.jeredecouvremalangue.feature.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("JS\\", "recurring notification, requesting notification service")
        //todo show the notification
    }
}