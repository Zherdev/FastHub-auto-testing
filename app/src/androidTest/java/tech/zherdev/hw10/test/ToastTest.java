/*
 * hw10: ToastTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.test;

import android.os.Build;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import tech.zherdev.hw10.page.FeedbackPage;
import tech.zherdev.hw10.page.HomePage;
import tech.zherdev.hw10.utils.Sidebar;

import static junit.framework.TestCase.assertTrue;

/**
 * Тест "Проверка Toast".
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class ToastTest extends authorizedBaseRunner {

    @Test
    public void toastTest() {
        HomePage homePage = app.homePage;

        Sidebar sidebar = homePage.openSidebar();
        sidebar.scrollToText("Send feedback");
        sidebar.click("Send feedback");

        FeedbackPage feedbackPage = app.feedbackPage;
        feedbackPage.waitUntilPageLoadedByText("You are currently using a debug build");
        feedbackPage.closeDebugMessageIfOpened();
        feedbackPage.setTitle("hello");
        feedbackPage.clickDesciption();

        String deviceInfo2 = feedbackPage.getDescription();
        assertTrue(deviceInfo2.contains(Build.MANUFACTURER));
        assertTrue(deviceInfo2.contains(Build.BRAND));
        assertTrue(deviceInfo2.contains(Build.MODEL));
        Log.i("tech.zherdev", "Device information верна");
    }

}
