/*
 * hw11: Sidebar
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.utils;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.NavigationViewActions;

import com.fastaccess.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;

/**
 * Класс Sidebar представляет боковое меню.
 *
 * @author Ivan Zherdev
 */
public class Sidebar {

    private ViewInteraction sidebar = onView(withId(R.id.mainNav));

    public void navigateTo(int id) {
        sidebar.perform(NavigationViewActions.navigateTo(id));
    }

}