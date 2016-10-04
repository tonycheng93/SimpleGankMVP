package com.skyworth.simplegank.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Sky000 on 2016/9/29.
 */

public class ActivityUtil {

    public static void addFragmenToActivity(
            FragmentManager fragmentManager,
            Fragment fragment,
            int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
