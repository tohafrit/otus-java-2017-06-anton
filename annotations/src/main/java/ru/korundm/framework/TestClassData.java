package ru.korundm.framework;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton.
 */
public class TestClassData {

    private Class<?> klass;
    private List<Method> beforeList = new ArrayList<>();
    private List<Method> testList = new ArrayList<>();
    private List<Method> afterList = new ArrayList<>();

    public TestClassData(Class<?> klass) {
        this.klass = klass;
    }

    public Class<?> getKlass() {
        return klass;
    }

    public void setKlass(Class<?> klass) {
        this.klass = klass;
    }

    public List<Method> getBeforeList() {
        return beforeList;
    }

    public void setBeforeList(List<Method> beforeList) {
        this.beforeList = beforeList;
    }

    public List<Method> getTestList() {
        return testList;
    }

    public void setTestList(List<Method> testList) {
        this.testList = testList;
    }

    public List<Method> getAfterList() {
        return afterList;
    }

    public void setAfterList(List<Method> afterList) {
        this.afterList = afterList;
    }
}
