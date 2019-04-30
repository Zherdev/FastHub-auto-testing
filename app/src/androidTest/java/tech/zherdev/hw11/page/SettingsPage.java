/*
 * hw11: SttingsPage
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.page;

import com.fastaccess.R;
import com.fastaccess.data.dao.SettingsModel;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Класс SettingsPage представляет страницу настроек в приложении.
 *
 * @author Ivan Zherdev
 */
public class SettingsPage extends Page {

    public SettingsPage goToThemes() {
        onData(anything())
                .inAdapterView(withId(R.id.settingsList))
                .atPosition(SettingsModel.THEME)
                .perform(click());
        return this;
    }

}