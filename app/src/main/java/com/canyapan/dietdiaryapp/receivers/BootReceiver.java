package com.canyapan.dietdiaryapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;

import com.canyapan.dietdiaryapp.SettingsActivity;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (preferences.getBoolean(SettingsActivity.KEY_NOTIFICATIONS_ACTIVE, true)) {
                DailyAlarmReceiver.register(context, preferences);
            }
        }
    }
}
