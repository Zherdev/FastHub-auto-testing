/*
 * hw11: ConcreteApplication
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.app;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

/**
 * Класс ConcreteApplication предстаявляет конкретное тестируемое приложение.
 *
 * @param <T> активити, с которой начинается тест
 * @author Ivan Zherdev
 */
public class ConcreteApplication<T extends Activity> extends AbstractApplication {

    private final ActivityTestRule<T> rule;

    public ConcreteApplication(Class<T> clazz) {
        rule = new ActivityTestRule<>(clazz, true, false);
    }

    public T launch() {
        return rule.launchActivity(null);
    }

    public T launch(Intent intent) {
        return rule.launchActivity(intent);
    }

}