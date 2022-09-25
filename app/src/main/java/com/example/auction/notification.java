package com.example.auction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class notification extends AppCompatActivity {

    private static final String Chanel_ID = "My channel";
    private static final int Notificaton_ID = 101;
    Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notifyBtn = findViewById(R.id.notifyBtn);


//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel("My Channel", "New Channel", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager nm = getSystemService(NotificationManager.class);
//            nm.createNotificationChannel(channel);
//        }
//
//        notifyBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(notification.this, "My Notification");
//                builder.setContentText("New message from Auction");
//                builder.setContentTitle("BidzzApp");
//                builder.setSmallIcon(R.drawable.b2);
//                builder.setAutoCancel(true);
//
//                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(notification.this);
//                managerCompat.notify(101, builder.build());
//
//            }
//        });


        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.b2, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();


//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            notification = new Notification.Builder(this)
//                    .setLargeIcon(largeIcon)
//                    .setSmallIcon(R.drawable.b2)
//                    .setContentText("New Message")
//                    .setSubText("New message from Auction")
//                    .setChannelId(Chanel_ID)
//                    .build();
//
//            nm.createNotificationChannel(new NotificationChannel(Chanel_ID, "New channel", NotificationManager.IMPORTANCE_HIGH));
//        }
//        else{
//            notification = new Notification.Builder(this)
//                    .setLargeIcon(largeIcon)
//                    .setSmallIcon(R.drawable.b2)
//                    .setContentText("New Message")
//                    .setSubText("New message from Auction")
//                    .build();
//        }
//
//        nm.notify(Notificaton_ID, notification);

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    notification = new Notification.Builder(notification.this)
                        .setLargeIcon(largeIcon)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentText("New Message")
                        .setSubText("New message from Auction")
                        .setChannelId(Chanel_ID)
                        .build();

                    nm.createNotificationChannel(new NotificationChannel(Chanel_ID, "New channel", NotificationManager.IMPORTANCE_HIGH));
                }
                else{
                    notification = new Notification.Builder(notification.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.b2)
                            .setContentText("New Message")
                            .setSubText("New message from Auction")
                            .build();
                }

                nm.notify(Notificaton_ID, notification);

            }
        });
    }
}