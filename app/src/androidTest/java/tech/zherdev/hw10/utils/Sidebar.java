/*
 * Sidebar
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.utils;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
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

    public void scrollDown() {
        sidebar.swipe(Direction.UP, 1.0f);
    }

    public void scrollToText(String text) {
        while (!sidebar.hasObject(By.text(text))) {
            sidebar.swipe(Direction.UP, 0.2f);
        }
    }
}
