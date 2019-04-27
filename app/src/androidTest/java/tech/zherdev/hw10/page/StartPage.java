/*
 * hw10: StartPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

/**
 * Класс StartPage представляет стартовую страницу приложения.
 *
 * @author Ivan Zherdev
 */
public class StartPage extends Page {

    public StartPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void closeChangelogIfOpened() {
        if (mDevice.hasObject(By.text("Changelog"))) {
            mDevice.pressBack();
            waitForWindowUpdate();
            Log.i("tech.zherdev", "StartPage: Закрыли changelog");
        }
    }

    public void basicAuthentication(String login, String pass) {
        if (mDevice.hasObject(By.res(
                "com.fastaccess.github.debug", "loginForm"))) {
            mDevice.findObject(By.text("Basic Authentication")).click();
            waitForWindowUpdate();

            mDevice.findObject(By.res("com.fastaccess.github.debug", "usernameEditText"))
                    .setText(login);
            mDevice.findObject(By.res("com.fastaccess.github.debug", "passwordEditText"))
                    .setText(pass);
            mDevice.findObject(By.res("com.fastaccess.github.debug", "login"))
                    .click();
            waitForWindowUpdate();

            Log.i("tech.zherdev", "StartPage: Авторизовались в приложении");
        }
        Log.w("tech.zherdev", "StartPage: Нет формы входа, авторизация невозможна " +
                "или не требуется");
    }

}
