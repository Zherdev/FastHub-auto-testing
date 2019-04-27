/*
 * hw10: AboutPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.page;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс AboutPage представляет страницу Settings->About.
 *
 * @author Ivan Zherdev
 */
public class AboutPage extends Page {

    public AboutPage(UiDevice mDevice) {
        super(mDevice);
    }

    public void scrollToBlock(String blockName) {
        UiObject2 parent = mDevice.findObject(
                By.res(FASTHUB_PACKAGE, "mal_recyclerview"));
        while (parent.findObjects(By.text(blockName)).isEmpty()) {
            parent.scroll(Direction.DOWN, 0.1f);
            waitForWindowUpdate();
        }
        Log.i("tech.zherdev", "AboutPage: Проскроллили вниз");
    }

    /**
     * @param blockName имя блока
     * @return список опций, находящихся в блоке
     */
    public ArrayList<UiObject2> getOptionsFromBlock(String blockName) {
        UiObject2 parent = mDevice.findObject(
                By.res(FASTHUB_PACKAGE, "mal_recyclerview"));
        return new ArrayList<>(parent.findObject(By.text(blockName)).getParent()
                .findObject(By.clazz("android.support.v7.widget.RecyclerView"))
                .getChildren());
    }

}
