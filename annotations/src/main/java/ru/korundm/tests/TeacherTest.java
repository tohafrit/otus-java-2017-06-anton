package ru.korundm.tests;

import ru.korundm.framework.annotations.Before;
import ru.korundm.framework.annotations.Test;

/**
 * Created by anton.
 */
public class TeacherTest {

    @Before
    public void beforeMethodTest() {
        System.out.println("Launch TeacherTest.beforeMethodTest");
    }

    @Test
    public void testMethodTest() {
        System.out.println("Launch TeacherTest.testMethodTest");
    }

    public void afterMethodTest() {
        System.out.println("Launch TeacherTest.afterMethodTest");
    }
}
