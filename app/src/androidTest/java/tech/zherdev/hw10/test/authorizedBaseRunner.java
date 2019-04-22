/*
 * authorizedBaseRunner
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw10.test;

import org.junit.After;
import org.junit.Before;

import tech.zherdev.hw10.app.Application;
import tech.zherdev.hw10.page.StartPage;

import static tech.zherdev.hw10.utils.Utils.getAuthData;

/**
 * Класс authorizedBaseRunner является родительским для всех тестов
 * с предусловием: пользователь авторизован в приложении.
 *
 * @author Ivan Zherdev
 */
public class authorizedBaseRunner {

    public Application app;

    @Before
    public void setUp() {
        app = new Application();

        StartPage startPage = app.startPage;
        startPage.closeChangelogIfOpened();
        String[] authData = getAuthData(); // login, pass
        startPage.basicAuthentication(authData[0], authData[1]);
        startPage.waitUntilPageLoadedByAppbar();
    }

    @After
    public void tearDown() {
        app.close();
    }

}
