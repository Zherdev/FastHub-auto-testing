/*
 * hw11: OpenTrendingTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.test;

import android.support.test.runner.AndroidJUnit4;

import com.fastaccess.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import tech.zherdev.hw11.page.HomePage;
import tech.zherdev.hw11.utils.Sidebar;

/**
 * Тест "Открытие Trending"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
public class OpenTrendingTest extends authorizedBaseRunner {

    @Test
    public void openTrendingTest() {
        HomePage homePage = new HomePage();

        Sidebar sidebar = homePage.openSidebar();
        sidebar.navigateTo(R.id.trending);

        homePage.checkPageByName("Trending");
    }

}