package org.firstinspires.ftc.teamcode.functions;

/*
 * FOR THIS CLASS, YOU HAVE TO DO SOMETHING
 * in Android Studio, go to:
 *   TeamCode > manifests > AndroidManifest.xml
 *
 * and from:
 *   <manifest
 *       package="org.firstinspires.ftc.teamcode"
 *       xmlns:android="http://schemas.android.com/apk/res/android">
 *       <application/>
 *   </manifest>
 *
 * transform to:
 *   <manifest
 *      package="org.firstinspires.ftc.teamcode"
 *      xmlns:android="http://schemas.android.com/apk/res/android">
 *
 *      <application android:name="org.firstinspires.ftc.teamcode.functions.MyApplication">
 *      </application>
 *
 *      <application/>
 *  </manifest>
 *
 * don't look at me idk why
 */

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}