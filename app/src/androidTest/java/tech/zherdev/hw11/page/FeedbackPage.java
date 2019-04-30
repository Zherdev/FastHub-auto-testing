/*
 * hw11: FeedbackPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.page;

import android.os.Build;
import android.support.test.espresso.NoMatchingViewException;

import com.fastaccess.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringContains.containsString;
import static tech.zherdev.hw11.mathcer.CustomMatchers.hasValueEqualTo;

/**
 * Класс FeedbackPage представляет страницу отправки фидбека в приложении.
 *
 * @author Ivan Zherdev
 */
public class FeedbackPage extends Page {

    public FeedbackPage closeDebugMessageIfOpened() {
        try {
            onView(withText("You are currently using a debug build"))
                    .check(matches(isDisplayed()));
            pressBack();
        } catch (NoMatchingViewException e) { } // Нет changelog'
        return this;
    }

    public FeedbackPage setTitle(String text) {
        onView(withClassName(containsString("TextInputEditText")))
                .perform(click(), typeText(text), closeSoftKeyboard());
        return this;
    }

    public FeedbackPage clickDesciption() {
        onView(withResourceName("description"))
                .perform(click());
        return this;
    }

    public FeedbackPage checkDescription() {
        onView(withResourceName("editText"))
                .check(matches(hasValueEqualTo(Build.MANUFACTURER)))
                .check(matches(hasValueEqualTo(Build.BRAND)))
                .check(matches(hasValueEqualTo(Build.MODEL)));
        return this;
    }

    public FeedbackPage submit() {
        onView(withId(R.id.submit)).perform(click());
        return this;
    }

}
