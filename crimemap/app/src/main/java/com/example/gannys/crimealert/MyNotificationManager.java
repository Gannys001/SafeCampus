package com.example.gannys.crimealert;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
public class MyNotificationManager {
    private static boolean notificationSent;
    private static NotificationManager nm;
    private NotificationCompat.Builder mBuilder;
    public static void createNotificationChannel(NotificationManager notificationManager){
        nm = notificationManager;
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("channel", "geofence", importance);
        channel.setDescription("Notify when entering or exiting a high crime zone");
        notificationManager.createNotificationChannel(channel);
    }
    public void sendNotification(String status){
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Location Update")
                .setContentText(status + " high crime zone.")
                .setPriority(-2)
                .setAutoCancel(false)
                .setOnlyAlertOnce(true);
        //.setContentIntent(tapPendingIntent)
        nm.notify(0, mBuilder.build());
        notificationSent = true;
    }
    public void setNotificationBuilder(NotificationCompat.Builder mBuilder){
        this.mBuilder = mBuilder;
    }
}