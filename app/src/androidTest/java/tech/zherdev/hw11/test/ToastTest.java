/*
 * hw11: RestorePurchasesTest
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.test;

import android.support.test.espresso.intent.Intents;
import android.support.test.runner.AndroidJUnit4;

import com.fastaccess.R;
import com.fastaccess.ui.modules.main.donation.CheckPurchaseActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import tech.zherdev.hw11.page.HomePage;
import tech.zherdev.hw11.utils.Sidebar;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Тест "Restore Purchases"
 *
 * @author Ivan Zherdev
 */
@RunWith(AndroidJUnit4.class)
public class ToastTest extends authorizedBaseRunner {

    @Test
    public void restorePurchasesTest() {
        Intents.init();

        HomePage homePage = new HomePage();
        Sidebar sidebar = homePage.openSidebar();
        sidebar.navigateTo(R.id.restorePurchase);
        intended(hasComponent(CheckPurchaseActivity.class.getName()));

        Intents.release();
    }

}