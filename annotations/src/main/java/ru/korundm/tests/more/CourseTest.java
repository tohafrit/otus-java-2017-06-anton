package ru.korundm.tests.more;

import ru.korundm.framework.annotations.Test;

/**
 * Created by anton.
 */
public class CourseTest {

    public void beforeMethodTest() {
        System.out.println("Launch CourseTest.beforeMethodTest");
    }

    @Test
    public void testMethodTest() {
        System.out.println("Launch CourseTest.testMethodTest");
    }

    public void afterMethodTest() {
        System.out.println("Launch CourseTest.afterMethodTest");
    }
}
