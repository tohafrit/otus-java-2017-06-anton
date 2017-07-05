package ru.korundm;

import java.util.ArrayList;

/**
 * @author anton
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Benchmark benchmark = new Benchmark();

        benchmark.getMemorySize(Object::new);

        benchmark.getMemorySize(() -> "");

        benchmark.getMemorySize(() -> new int[0]);

        benchmark.getMemorySize(ArrayList::new);
    }
}
