package ru.korundm;

import ru.korundm.framework.TestLaunching;
import ru.korundm.tests.StudentTest;
import ru.korundm.tests.TeacherTest;

import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

/**
 * Created by anton.
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, URISyntaxException {
        System.out.println("Working with Class[]");
        TestLaunching.run(new Class[]{StudentTest.class, TeacherTest.class});
        System.out.println("Working with package");
        TestLaunching.run("ru.korundm.tests");
    }
}
