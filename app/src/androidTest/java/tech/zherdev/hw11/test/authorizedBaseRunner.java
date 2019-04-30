/*
 * hw11: authorizedBaseRunner
 *
 * Ivan Zherdev, 2019
 */

package tech.zherdev.hw11.test;

import android.app.Activity;

import com.fastaccess.ui.modules.main.MainActivity;

import org.junit.Before;

import tech.zherdev.hw11.app.ConcreteApplicationTest;

/**
 * Класс authorizedBaseRunner является родительским для всех тестов
 * с предусловием: пользователь авторизован в приложении.
 *
 * @author Ivan Zherdev
 */
public class authorizedBaseRunner extends ConcreteApplicationTest<MainActivity> {

    protected Activity activity;

    public authorizedBaseRunner() {
        super(MainActivity.class);
    }

    @Before
    @Override
    public void setUp() {
        super.setUp();
        activity = launch();
    }

}
