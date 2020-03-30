package com.example.notifyme

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService

@RequiresApi(Build.VERSION_CODES.O)

class NotificationHelper(context: Context): ContextWrapper(context) {

    val manager:NotificationManager by lazy {

        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    }

    init {
            val chan1= NotificationChannel(firstchannel,"first channel", NotificationManager.IMPORTANCE_DEFAULT)
            chan1.lightColor=Color.GREEN
            chan1.lockscreenVisibility=Notification.VISIBILITY_PRIVATE
            manager.createNotificationChannel(chan1)

        val chan2= NotificationChannel(secondchannel,"second channel", NotificationManager.IMPORTANCE_DEFAULT)
        chan2.lightColor=Color.GREEN
        chan2.lockscreenVisibility=Notification.VISIBILITY_PRIVATE
        manager.createNotificationChannel(chan2)



        val chan3= NotificationChannel(thirdchannel,"third channel", NotificationManager.IMPORTANCE_DEFAULT)
        chan3.lightColor=Color.GREEN
        chan3.lockscreenVisibility=Notification.VISIBILITY_PRIVATE
        manager.createNotificationChannel(chan3)

    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getNotification1(title:String, body:String):Notification.Builder{
        return Notification.Builder(applicationContext, firstchannel)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.bulbasaur)
            .setAutoCancel(true)
    }

    fun getNotification2(title:String, body:String):Notification.Builder{
        return Notification.Builder(applicationContext, secondchannel)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.bulbasaur)
            .setAutoCancel(true)
    }

    fun getNotification3(title:String, body:String):Notification.Builder{
        return Notification.Builder(applicationContext, thirdchannel)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.bulbasaur)
            .setAutoCancel(true)
    }


    fun Notify(id:Int,notification: Notification.Builder){
        manager.notify(id,notification.build())
    }



    companion object{
        val firstchannel="first"
        val secondchannel="second"
        val thirdchannel="third"
    }
}