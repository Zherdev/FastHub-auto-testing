/*
 * Sidebar
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.utils;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;

/**
 * Класс Sidebar представляет боковое меню.
 *
 * @author Ivan Zherdev
 */
public class Sidebar {

    private UiObject2 sidebar;

    public Sidebar(UiObject2 sidebar) {
        this.sidebar = sidebar;
    }

    public void click(String text) {
        sidebar.findObject(By.text(text)).click();
        Log.i("tech.zherdev", "Нажали " + text + " в боковом меню");
    }
}
