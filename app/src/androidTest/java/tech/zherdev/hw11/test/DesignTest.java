/*
 * hw11: DesignTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.test;

import android.support.test.runner.AndroidJUnit4;

import com.fastaccess.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import tech.zherdev.hw11.page.AboutPage;
import tech.zherdev.hw11.page.HomePage;
import tech.zherdev.hw11.utils.Sidebar;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Тест "Верстка"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
public class DesignTest extends authorizedBaseRunner {

    @Test
    public void designTest() {
        HomePage homePage = new HomePage();

        Sidebar sidebar = homePage.openSidebar();
        sidebar.navigateTo(R.id.about);

        AboutPage aboutPage = new AboutPage();

        // Тест падает даже на простой проверке отображения иконки. Но ведь она есть...
        // Писал/гуглил drawable матчеры, однако для векторных изображений решения не нашел.
        onView(withId(R.drawable.ic_track_changes)).check(matches(isDisplayed()));
    }

}