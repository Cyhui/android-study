package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理所有的活动
 * Created by 54459 on 2017/6/1 0001.
 */

public class ActivityCollector {

    public static List<Activity> activitys = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activitys.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activitys.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
