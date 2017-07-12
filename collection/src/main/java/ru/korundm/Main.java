package ru.korundm;

import java.util.Collections;
import java.util.List;

/**
 * Created anton
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> addList = new MyArrayList<>();

        addList.add(15);
        Collections.addAll(addList, 1, 10, 7);
        System.out.println("Collections.addAll: " + addList);

        List<Integer> copyList = new MyArrayList<>(addList.size());
        Collections.copy(copyList, addList);
        System.out.println("Collections.copy: " + copyList);

        Collections.sort(copyList);
        System.out.println("Collections.sort: " + copyList);
    }
}
