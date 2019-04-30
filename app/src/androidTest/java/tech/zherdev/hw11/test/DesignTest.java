/*
 * hw11: ToastTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.test;

import android.support.test.runner.AndroidJUnit4;

import com.fastaccess.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import tech.zherdev.hw11.page.FeedbackPage;
import tech.zherdev.hw11.page.HomePage;
import tech.zherdev.hw11.utils.Sidebar;

/**
 * Тест "Проверка Toast"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
public class DesignTest extends authorizedBaseRunner {

    @Test
    public void toastTest() {
        HomePage homePage = new HomePage();

        Sidebar sidebar = homePage.openSidebar();
        sidebar.navigateTo(R.id.reportBug);

        FeedbackPage feedbackPage = new FeedbackPage();
        feedbackPage.closeDebugMessageIfOpened();
        feedbackPage.setTitle("hello");
        feedbackPage.clickDesciption();
        feedbackPage.checkDescription();

        feedbackPage
                .submit()
                .submit();
        feedbackPage.checkToastByText("Message was sent", activity);
    }

}