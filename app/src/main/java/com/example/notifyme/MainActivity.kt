package com.example.notifyme

import android.app.Notification
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var notificationHelper:NotificationHelper?=null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationHelper= NotificationHelper(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun ch1Click(view: View){

        notificationHelper!!.Notify(1, notificationHelper!!.getNotification1("first", etMessage.text.toString()))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun ch2Click(view: View){
        notificationHelper!!.Notify(2, notificationHelper!!.getNotification2("second", etMessage.text.toString()))

    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun ch3Click(view: View){
        notificationHelper!!.Notify(3, notificationHelper!!.getNotification3("third", etMessage.text.toString()))

    }
}

