package com.rookie.bigdata.helloworld3;

/**
 * @Classname HelloListener
 * @Description
 * @Author rookie
 * @Date 2023/2/3 11:20
 * @Version 1.0
 */

import javax.management.Notification;
import javax.management.NotificationListener;

public class HelloListener implements NotificationListener {

    public void handleNotification(Notification notification, Object handback) {
        if (handback instanceof Hello) {
            Hello hello = (Hello) handback;
            hello.printHello(notification.getMessage());
        }
    }

}
