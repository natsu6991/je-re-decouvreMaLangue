package jrml.supinternet.com.jeredecouvremalangue.feature.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.support.v4.app.NotificationCompat
import jrml.supinternet.com.jeredecouvremalangue.R
import android.app.PendingIntent
import jrml.supinternet.com.jeredecouvremalangue.feature.word.SingleWordActivity
import android.support.v4.app.NotificationManagerCompat
import jrml.supinternet.com.jeredecouvremalangue.data.WordService
import jrml.supinternet.com.jeredecouvremalangue.feature.word.Word


class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val wordId = WordService.getRandomWordId()
        val pendingIntent = getActivityIntent(context, wordId)
        val word = WordService.getWord(wordId)

        //val testwordId = pendingIntent.getIntExtra("listId", 1000)
        Log.d("JS\\singleWordActivity", "id is " + wordId)

        val mBuilder = NotificationCompat.Builder(context, context.getString(R.string.channel_id))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(word?.name)
                .setContentText("Connaissez vous ce mot?")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(context)

        // notificationId is a unique int for each notification that you must define
        //currently, there is only one notification, so id isn't important...
        notificationManager.notify(1, mBuilder.build())

    }

    private fun getActivityIntent(context: Context, wordId: Int) :PendingIntent{
        // Create an explicit intent for an Activity in your app
        val intent = Intent(context, SingleWordActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        Log.d("JS\\notifReceiver", "id is " + wordId)

        intent.putExtra("listId", wordId)
        return PendingIntent.getActivity(context, 0, intent, 0)

    }
}