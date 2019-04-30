/*
 * hw11: AbstractApplication
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.app;

import android.Manifest;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Класс AbstractApplication представляет некоторое тестируемое приложение.
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
public class AbstractApplication {

    @Before
    public void setUp() {
        grantPermissions();
        getDevice().pressHome();
        getDevice().pressBack();
    }

    public UiDevice getDevice() {
        return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @RequiresApi(21)
    private void grantPermissions() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Context targetContext = InstrumentationRegistry
                .getInstrumentation().getTargetContext();
        try {
            getDevice().executeShellCommand(
                    String.format(
                            "pm grant %s %s",
                            context.getPackageName(),
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
            );
            getDevice().executeShellCommand(
                    String.format(
                            "pm grant %s %s",
                            targetContext.getPackageName(),
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
            );
        } catch (IOException e) {
            Log.e("tech.zherdev: AbstractApplication",
                    "Unable to grant permissions");
        }
    }

}