/*
 * hw11: AboutPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.page;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withParentIndex;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Класс AboutPage представляет страницу About в приложении.
 *
 * @author Ivan Zherdev
 */
public class AboutPage extends Page {

    /**
     * Метод checkRecycler(...) осуществляет проверку списка на странице.
     *
     * @param matcher матчер, по которому ищется элемент
     * @param position позиция в списке
     */
    public void checkRecycler(Matcher<View> matcher, int position) {
        onView(allOf(
                withParent(allOf(
                    withClassName(containsString("LinearLayout")),
                    withParentIndex(position))),
                matcher))
                .check(matches(isDisplayed()));
    }

}