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
import tech.zherdev.hw11.page.SettingsPage;
import tech.zherdev.hw11.page.ThemesPage;
import tech.zherdev.hw11.utils.Sidebar;

/**
 * Тест "Смена темы"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
public class ChangeThemeTest extends authorizedBaseRunner {

    @Test
    public void changeThemeTest() {
        HomePage homePage = new HomePage();

        Sidebar sidebar = homePage.openSidebar();
        sidebar.navigateTo(R.id.settings);

        SettingsPage settingsPage = new SettingsPage();
        settingsPage.goToThemes();

        ThemesPage themesPage = new ThemesPage();
        themesPage
                .swipeToRightTheme()
                .applyTheme()
                .checkThemeByColor(-3355444); // Цвет элемента в серой теме
    }

}