/*
 * SettingsPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

/**
 * Класс SettingsPage представляет страницу настроек приложения.
 *
 * @author Ivan Zherdev
 */
public class SettingsPage extends Page {

    public SettingsPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void click(String text) {
        mDevice.findObject(By.res(FASTHUB_PACKAGE, "settingsList"))
                .findObject(By.text(text)).click();
        waitForWindowUpdate();
        Log.i("tech.zherdev", "SettingsPage: Выбрали " + text + " в настройках");
    }

}
