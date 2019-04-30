/*
 * CustomMatchers
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.mathcer;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatchers {

    /**
     * Матчит N-ное вхождение элемента.
     *
     * @param matcher исходный матчер
     * @param n       индекс вхождения элемента
     * @return TypeSafeMatcher
     */
    public static Matcher<View> getElementFromMatchAtPosition(final Matcher<View> matcher, final int n) {
        return new TypeSafeMatcher<View>() {

            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(n);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == n;
            }
        };
    }

    public static Matcher<View> hasValueEqualTo(final String content) {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("Has EditText/TextView the value:  " + content);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextView) && !(view instanceof EditText)) {
                    return false;
                }
                if (view != null) {
                    String text;
                    if (view instanceof TextView) {
                        text = ((TextView) view).getText().toString();
                    } else {
                        text = ((EditText) view).getText().toString();
                    }

                    return (text.contains(content));
                }
                return false;
            }
        };
    }

}
