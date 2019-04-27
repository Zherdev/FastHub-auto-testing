/*
 * hw10: DesignTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.test;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import tech.zherdev.hw10.page.AboutPage;
import tech.zherdev.hw10.page.HomePage;
import tech.zherdev.hw10.utils.Sidebar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Тест "Верстка"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class DesignTest extends authorizedBaseRunner {

    @Test
    public void designTest() {
        HomePage homePage = app.homePage;

        Sidebar sidebar = homePage.openSidebar();

        sidebar.scrollDown();
        sidebar.click("About");

        AboutPage aboutPage = app.aboutPage;
        aboutPage.waitUntilPageLoadedByText("FastHub Debug");
        aboutPage.scrollToBlock("About");

        // Позиции блока About
        ArrayList<UiObject2> optionsList = aboutPage.getOptionsFromBlock("About");

        assertEquals("Changelog", optionsList.get(1).findObject(
                By.clazz("android.widget.TextView")).getText());
        Log.i("tech.zherdev", "На второй позиции отображается текст 'Changelog'");

        assertTrue(optionsList.get(1).hasObject(
                By.clazz("android.widget.ImageView")));
        Log.i("tech.zherdev", "На второй позиции отображается иконка");
    }

}
