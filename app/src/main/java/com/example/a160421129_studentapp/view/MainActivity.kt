package com.example.a160421129_studentapp.view

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.a160421129_studentapp.R
import com.example.a160421129_studentapp.util.createNotificationChannel


class MainActivity : AppCompatActivity() {

    init {
        instance = this
    }

    companion object{
        private var instance:MainActivity ?= null

        fun showNotification(title: String, content:String, icon: Int) {
            val channelId = "${instance?.packageName}-${instance?.getString(R.string.app_name)}"

            val notificationBuilder = NotificationCompat.Builder(instance!!.applicationContext,
                                        channelId).apply {
                                            setSmallIcon(icon)
                                            setContentTitle(title)
                                            setContentText(content)
                                            setStyle(NotificationCompat.BigTextStyle())
                                            priority = NotificationCompat.PRIORITY_DEFAULT
                                            setAutoCancel(true)
            }

            val manager = NotificationManagerCompat.from(instance!!.applicationContext.applicationContext!!)
            if(ActivityCompat.checkSelfPermission(instance!!.applicationContext,Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED){
                return
            }
            manager.notify(1001, notificationBuilder.build())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
                                    getString(R.string.app_name), "Notification channel for " + "creating new student")


    }
}