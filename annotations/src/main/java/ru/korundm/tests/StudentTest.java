package ru.korundm.tests;

import ru.korundm.framework.annotations.After;
import ru.korundm.framework.annotations.Before;
import ru.korundm.framework.annotations.Test;

/**
 * Created by anton.
 */
public class StudentTest {

    @Before
    public void beforeMethodTest() {
        System.out.println("Launch StudentTest.beforeMethodTest");
    }

    @Test
    public void testMethodTest() {
        System.out.println("Launch StudentTest.testMethodTest");
    }


    @Test
    public void testMethodTest2() {
        System.out.println("Launch StudentTest.testMethodTest2");
    }

    @After
    public void afterMethodTest() {
        System.out.println("Launch StudentTest.afterMethodTest");
    }
}
