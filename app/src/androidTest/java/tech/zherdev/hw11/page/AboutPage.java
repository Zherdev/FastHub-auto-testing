/*
 * hw11: ThemesPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.page;

import android.support.test.espresso.contrib.ViewPagerActions;

import com.fastaccess.App;
import com.fastaccess.R;
import com.fastaccess.helper.ViewHelper;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static tech.zherdev.hw11.mathcer.CustomMatchers.getElementFromMatchAtPosition;

/**
 * Класс ThemesPage представляет страницу смены тем в приложении.
 *
 * @author Ivan Zherdev
 */
public class AboutPage extends Page {

    public AboutPage swipeToRightTheme() {
        onView(withId(R.id.pager))
                .perform(ViewPagerActions.scrollRight());
        return this;
    }

    public AboutPage applyTheme() {
        onView(getElementFromMatchAtPosition(withId(R.id.apply), 1))
            .perform(click());
        return this;
    }

    public AboutPage checkThemeByColor(int color) {
        // Цвет определяется по ViewHelper'у
        assertEquals(color, ViewHelper.getPrimaryColor(App.getInstance().getBaseContext()));
        return this;
    }

}