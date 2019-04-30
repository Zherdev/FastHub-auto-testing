/*
 * hw11: ConcreteApplicationTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.app;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

/**
 * Класс ConcreteApplicationTest предназначен для тестировния конкретного приложения.
 *
 * @param <T> активити, с которой начинается тест
 * @author Ivan Zherdev
 */
public class ConcreteApplicationTest<T extends Activity> extends AbstractApplicationTest {

    private final ActivityTestRule<T> rule;

    public ConcreteApplicationTest(Class<T> clazz) {
        rule = new ActivityTestRule<>(clazz, true, false);
    }

    public T launch() {
        return rule.launchActivity(null);
    }

    public T launch(Intent intent) {
        return rule.launchActivity(intent);
    }

}