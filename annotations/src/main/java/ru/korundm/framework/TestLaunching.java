package ru.korundm.framework;

import ru.korundm.framework.annotations.After;
import ru.korundm.framework.annotations.Before;
import ru.korundm.framework.annotations.Test;
import ru.korundm.helpers.FileHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton.
 */
public class TestLaunching {

    private TestLaunching() {
    }

    public static void run(Class<?>[] classes) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List<TestClassData> tcdList = preparationData(classes);
        if(!tcdList.isEmpty()) {
            for(TestClassData tcd : tcdList) {
                for(Method test : tcd.getTestList()) {
                    Object instance = tcd.getKlass().newInstance();
                    // before
                    for(Method before : tcd.getBeforeList()) {
                        before.invoke(instance);
                    }
                    // test
                    test.invoke(instance);
                    //after
                    for(Method after : tcd.getAfterList()) {
                        after.invoke(instance);
                    }
                }
            }
        }
    }

    public static void run(String packageName) throws IllegalAccessException, InvocationTargetException, InstantiationException, URISyntaxException {
        List<Class<?>> classList = FileHelper.getClasses(packageName);
        Class<?>[] classes = new Class[classList.size()];
        run(classList.toArray(classes));
    }

    private static List<TestClassData> preparationData(Class<?>[] classes) {
        List<TestClassData> tcdList = new ArrayList<>();
        for (Class<?> klass : classes){
            List<Method> before = new ArrayList<>();
            List<Method> test = new ArrayList<>();
            List<Method> after = new ArrayList<>();

            for (Method m : klass.getMethods()) {
                if (m.isAnnotationPresent(Before.class)) {
                    before.add(m);
                } else if (m.isAnnotationPresent(Test.class)) {
                    test.add(m);
                } else if (m.isAnnotationPresent(After.class)) {
                    after.add(m);
                }
            }
            if (!test.isEmpty()) {
                TestClassData tcd = new TestClassData(klass);
                tcd.setBeforeList(before);
                tcd.setTestList(test);
                tcd.setAfterList(after);
                tcdList.add(tcd);
            }
        }

        return tcdList;
    }
}
