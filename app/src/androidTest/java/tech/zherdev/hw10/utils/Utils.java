/*
 * Utils
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.utils;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс Utils предоставляет некоторые статические методы.
 *
 * @author Ivan Zherdev
 */
public class Utils {
    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    public static String getLauncherPackageName() {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    /** @return логин и пароль из /app/src/androidTest/assets/authData.txt */
    public static String[] getAuthData() {
        BufferedReader reader = null;
        String login = null;
        String pass = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    InstrumentationRegistry.getContext().getAssets().open("authData.txt")));
        } catch (IOException e) {
            Log.e("tech.zherdev", e.getMessage());
        }
        try {
            login = reader.readLine();
            pass = reader.readLine();
        } catch (IOException e) {
            Log.e("tech.zherdev", e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("tech.zherdev", e.getMessage());
                }
            }
        }
        return new String[] {login, pass};
    }

}
