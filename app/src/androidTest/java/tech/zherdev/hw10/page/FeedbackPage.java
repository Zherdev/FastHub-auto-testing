/*
 * FeedbackPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

/**
 * Класс FeedbackPage представляет страницу отправки feedback'а.
 *
 * @author Ivan Zherdev
 */
public class FeedbackPage extends Page {

    public FeedbackPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void closeDebugMessageIfOpened() {
        if (mDevice.hasObject(By.text(
                "You are currently using a debug build"))) {
            mDevice.pressBack();
            waitForWindowUpdate();
            Log.i("tech.zherdev", "FeedbackPage: Закрыли сообщение о дебаге");
        }
    }

    public void setTitle(String text) {
        mDevice.findObject(By.res(FASTHUB_PACKAGE, "title"))
                .findObject(By.clazz("android.widget.EditText"))
                .setText(text);
        waitForWindowUpdate();

        Log.i("tech.zherdev", "FeedbackPage: Записали " + text + " в title");
    }

    public void clickDesciption() {
        mDevice.findObject(By.res(FASTHUB_PACKAGE, "description"))
                .click();
        waitForWindowUpdate();

        Log.i("tech.zherdev", "FeedbackPage: Кликнули на description");
    }

    public String getDescription() {
        return mDevice.findObject(By.res(FASTHUB_PACKAGE, "editText"))
                .getText();
    }

}


