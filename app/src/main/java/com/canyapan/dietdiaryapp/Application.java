package com.canyapan.dietdiaryapp;

import net.danlew.android.joda.JodaTimeAndroid;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(
        formUri = "http://services.canyapan.com/acra-diet-diary-app/_design/acra-storage/_update/report",
        reportType = org.acra.sender.HttpSender.Type.JSON,
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        formUriBasicAuthLogin = "reporter",
        formUriBasicAuthPassword = "cLo9y}3sWUP%G75rzeR%dUSr6j*gkWJB",
        mode = ReportingInteractionMode.DIALOG,
        resToastText = R.string.crash_toast_text, // optional, displayed as soon as the crash occurs, before collecting data which can take a few seconds
        resDialogText = R.string.crash_dialog_text,
        resDialogIcon = android.R.drawable.ic_dialog_info, //optional. default is a warning sign
        resDialogTitle = R.string.crash_dialog_title, // optional. default is your application name
        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt, // optional. When defined, adds a user text field input with this text resource as a label
        resDialogOkToast = R.string.crash_dialog_ok_toast // optional. displays a Toast message when the user accepts to send a report.
)
public class Application extends android.app.Application {
    public static final String APP_DIR = "DietDiaryApp";

    @Override
    public void onCreate() {
        super.onCreate();

        JodaTimeAndroid.init(this);
        ACRA.init(this);
    }
}
