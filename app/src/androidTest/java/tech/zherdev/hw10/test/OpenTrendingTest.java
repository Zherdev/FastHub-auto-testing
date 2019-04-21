/*
 * OpenTrendingTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.test;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import tech.zherdev.hw10.page.HomePage;
import tech.zherdev.hw10.utils.Sidebar;

/**
 * Тест "Открытие Trending"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class OpenTrendingTest extends authorizedBaseRunner {

    @Test
    public void openTrendingTest() {
        HomePage homePage = app.homePage;

        Sidebar sidebar = homePage.openSidebar();

        sidebar.click("Trending");

        homePage.waitUntilPageLoaded();
        homePage.checkPageByName("Trending");
    }

}
