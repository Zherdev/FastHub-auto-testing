/*
 * hw10: ThemesPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import static org.junit.Assert.assertTrue;

/**
 * Класс ThemesPage представляет страницу выбора темы.
 *
 * @author Ivan Zherdev
 */
public class ThemesPage extends Page {

    public ThemesPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void swipeToRightTheme() {
        mDevice.findObject(By.res(FASTHUB_PACKAGE, "appbar"))
                .swipe(Direction.LEFT, 1.0f);
        waitForWindowUpdate();
        Log.i("tech.zherdev", "ThemesPage: Свайпнули до правой темы");
    }

    public void swipeToLeftTheme() {
        mDevice.findObject(By.res(FASTHUB_PACKAGE, "appbar"))
                .swipe(Direction.RIGHT, 1.0f);
        waitForWindowUpdate();
        Log.i("tech.zherdev", "ThemesPage: Свайпнули до левой темы");
    }

    public void applyTheme() {
        mDevice.findObject(By.clazz("android.widget.ImageButton")).click();
        waitForWindowUpdate();
        Log.i("tech.zherdev", "ThemesPage: Нажали на галочку");
    }

    public void checkThemeIsPremium() {
        assertTrue(mDevice.findObject(By.res(FASTHUB_PACKAGE, "appbar"))
                .hasObject(By.text("Premium Theme")));
    }
}
