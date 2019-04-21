/*
 * Application
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.app;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.util.Log;

import tech.zherdev.hw10.page.HomePage;
import tech.zherdev.hw10.page.StartPage;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static tech.zherdev.hw10.utils.Utils.getLauncherPackageName;

/**
 * Класс Application представляет тестируемое приложение.
 *
 * @author Ivan Zherdev
 */
public class Application {

    private static final String FASTHUB_PACKAGE
            = "com.fastaccess.github.debug";
    private static final int LAUNCH_TIMEOUT = 5000;

    public StartPage startPage;
    public HomePage homePage;

    private UiDevice mDevice;

    public Application() {

        Log.i("tech.zherdev","Запускаем " + FASTHUB_PACKAGE);

        appInit();

        startPage = new StartPage(mDevice);
        homePage = new HomePage(mDevice);
    }

    public void close() {
        mDevice.pressHome();
        mDevice = null;

        Log.i("tech.zherdev", "Завершаем " + FASTHUB_PACKAGE);
    }

    private void appInit() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        mDevice.pressHome();

        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(FASTHUB_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(FASTHUB_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }
}
