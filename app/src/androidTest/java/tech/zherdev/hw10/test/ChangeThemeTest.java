/*
 * ChangeThemeTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.test;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import tech.zherdev.hw10.page.HomePage;
import tech.zherdev.hw10.page.SettingsPage;
import tech.zherdev.hw10.page.ThemesPage;
import tech.zherdev.hw10.utils.Sidebar;

import static org.junit.Assert.assertEquals;

/**
 * Тест "Смена темы".
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ChangeThemeTest extends authorizedBaseRunner {

    @Rule
    public GrantPermissionRule permissionRule1 = GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    @Rule
    public GrantPermissionRule permissionRule2 = GrantPermissionRule.grant(Manifest.permission.READ_EXTERNAL_STORAGE);

    @Test
    public void changeThemeTest() {

        goToThemes();
        ThemesPage themesPage = app.themesPage;

        themesPage.swipeToRightTheme();
        themesPage.applyTheme();

        // Проверяем, что тема сменилась.
        goToThemes();
        themesPage.swipeToRightTheme();
        themesPage.checkThemeIsPremium();
        Log.i("tech.zherdev", "Тема сменилась");
    }

    private void goToThemes() {
        HomePage homePage = app.homePage;

        Sidebar sidebar = homePage.openSidebar();
        sidebar.scrollToText("Settings");
        sidebar.click("Settings");

        SettingsPage settingsPage = app.settingsPage;
        settingsPage.waitUntilPageLoadedByAppbar();
        settingsPage.click("Theme");

        ThemesPage themesPage = app.themesPage;
        themesPage.waitUntilPageLoadedByAppbar();
    }

}
