/*
 * OpenTrendingTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.EventCondition;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static tech.zherdev.hw10.Utils.getLauncherPackageName;

/**
 * Тест "Открытие Trending"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class OpenTrendingTest {

    private static final String FASTHUB_PACKAGE
            = "com.fastaccess.github.debug";

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final int TIMEOUT = 5000;

    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the blueprint app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(FASTHUB_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(FASTHUB_PACKAGE).depth(0)), LAUNCH_TIMEOUT);

        if (!mDevice.findObjects(By.text("Changelog")).isEmpty()) {
            mDevice.pressBack();
        }

        if (!mDevice.findObjects(By.res(
                "com.fastaccess.github.debug", "loginForm")).isEmpty()) {
            mDevice.findObject(By.text("Basic Authentication")).click();
            mDevice.waitForWindowUpdate(FASTHUB_PACKAGE, TIMEOUT);

            BufferedReader reader = null;
            String login = null;
            String pass = null;
            try {
                reader = new BufferedReader(new InputStreamReader(
                        InstrumentationRegistry.getContext().getAssets().open("authData.txt")));
            } catch (IOException e) {
                //
            }
            try {
                login = reader.readLine();
                pass = reader.readLine();
            } catch (IOException e) {
                //
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        //
                    }
                }
            }
            UiObject2 o = mDevice.findObject(By.res("com.fastaccess.github.debug", "usernameEditText"));
            o.setText(login);
            mDevice.findObject(By.res("com.fastaccess.github.debug", "passwordEditText"))
                    .setText(pass);
            mDevice.findObject(By.res("com.fastaccess.github.debug", "login"))
                    .click();

        }
        mDevice.wait(Until.hasObject(
                By.res("com.fastaccess.github.debug", "appbar")), TIMEOUT);
    }

    @Test
    public void openTrendingTest() {
        mDevice.findObject(By.res("com.fastaccess.github.debug", "appbar"))
                .findObject(By.clazz("android.widget.ImageButton")).click();
        mDevice.findObject(By.text("Trending")).click();
        mDevice.waitForWindowUpdate(FASTHUB_PACKAGE, TIMEOUT);
        assertFalse(mDevice.findObject(By.res("com.fastaccess.github.debug", "appbar"))
                .findObjects(By.text("Trending")).isEmpty());
    }

    @After
    public void closeApp() {
        mDevice.pressHome();
    }

}
