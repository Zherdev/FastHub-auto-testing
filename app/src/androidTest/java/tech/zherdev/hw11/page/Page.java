/*
 * hw11: Page
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.page;

import android.app.Activity;
import android.support.test.espresso.NoMatchingViewException;
import android.util.Log;
import android.view.View;

import com.fastaccess.R;

import org.hamcrest.Matcher;

import tech.zherdev.hw11.utils.Sidebar;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;

/**
 * Класс Page представляет страницу (экран) в приложении.
 *
 * @author Ivan Zherdev
 */
public class Page {

    /**
     * Метод openSidebar() открывает боковое меню.
     *
     * @return боковое меню
     */
    public Sidebar openSidebar() {
        onView(withId(R.id.drawer)).perform(open());
        return new Sidebar();
    }

    /**
     * Метод checkPageByName(...) проверяет, открыта ли страница,
     * по наличию ее названия в заголовке appbar.
     *
     * @param name название страницы
     */
    public void checkPageByName(String name) {
        onView(allOf(withText(name), isDescendantOfA(withResourceName("appbar"))))
                .check(matches(isDisplayed()));
    }

    /**
     * Метод checkToastByText(...) проверяет, появился ли тоаст.
     *
     * @param text текст на нем
     */
    public void checkToastByText(String text, Activity activity) {
        onView(withText(text))
                .inRoot(withDecorView(not(is(activity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

}
