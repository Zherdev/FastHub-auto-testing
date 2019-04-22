/*
 * Page
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.util.Log;

import tech.zherdev.hw10.utils.Sidebar;

import static org.junit.Assert.assertTrue;

/**
 * Класс Page представляет страницу (экран) в приложении.
 *
 * @author Ivan Zherdev
 */
public class Page {

    protected static final String FASTHUB_PACKAGE
            = "com.fastaccess.github.debug";
    protected final int TIMEOUT = 5000;
    protected UiDevice mDevice;

    public Page(UiDevice mDevice) {
        this.mDevice = mDevice;
    }

    public void waitForWindowUpdate() {
        mDevice.waitForWindowUpdate(FASTHUB_PACKAGE, TIMEOUT);
    }

    /**
     * Метод waitUntilPageLoadedByAppbar() ожидает, пока не загрузится страница.
     * Загруженность проверятеся по наличию элемента Appbar.
     */
    public void waitUntilPageLoadedByAppbar() {
        /* Загрузка проверяется по наличию элемента appbar */
        mDevice.wait(Until.hasObject(
                By.res(FASTHUB_PACKAGE, "appbar")), TIMEOUT);
        Log.i("tech.zherdev", "Страница " + this.getClass().getName() + " загружена");
    }

    /**
     * Метод waitUntilPageLoadedByText(...) ожидает, пока не загрузится страница.
     * Загруженность проверятеся по наличию текста на странице.
     *
     * @param text текст, ожидаемый на странице
     */
    public void waitUntilPageLoadedByText(String text) {
        /* Загрузка проверяется по наличию элемента appbar */
        mDevice.wait(Until.hasObject(
                By.text(text)), TIMEOUT);
        Log.i("tech.zherdev", "Страница " + this.getClass().getName() + " загружена");
    }

    /**
     * Метод checkPageByName(...) проверяет, открыта ли страница,
     * по наличию ее названия в заголовке appbar.
     *
     * @param name название страницы
     */
    public void checkPageByName(String name) {
        assertTrue(mDevice.findObject(By.res(FASTHUB_PACKAGE, "appbar"))
                .hasObject(By.text(name)));
        Log.i("tech.zherdev","Проверили: открыта страница с заголовком " + name);
    }

    /**
     * Метод openSidebar() открывает боковое меню.
     *
     * @return боковое меню
     */
    public Sidebar openSidebar() {
        mDevice.findObject(By.res("com.fastaccess.github.debug", "appbar"))
                .findObject(By.clazz("android.widget.ImageButton")).click();
        Log.i("tech.zherdev", "Открыли боковое меню");

        return new Sidebar(mDevice.findObject(By.res(FASTHUB_PACKAGE, "extrasNav")));
    }

}
