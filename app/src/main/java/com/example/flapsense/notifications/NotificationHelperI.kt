package com.example.flapsense.notifications

import android.app.Notification
import android.content.Context

interface NotificationHelperI {
    fun createAlertNotification()
    fun createForegroundNotification(): Notification
    fun initialise(context: Context)

}