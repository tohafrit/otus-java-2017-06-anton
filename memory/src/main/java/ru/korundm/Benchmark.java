package ru.korundm;

import java.util.function.Supplier;

/**
 * @author anton
 */
public class Benchmark {

    private final int count = 1000000;
    private Runtime runtime = Runtime.getRuntime();

    public void getMemorySize(Supplier<Object> supplier) throws InterruptedException {
        System.gc();
        Thread.sleep(100);
        long startMemory = getCurrentMemory();
        String objectName = supplier.get().getClass().getCanonicalName();
        Object[] objects = new Object[count];

        int i = 0;
        while( i < count ) {
            objects[i] = supplier.get();
            i++;
        }

        long finishMemory = getCurrentMemory();

        System.out.println( "Object's name: " + objectName + ", size: " + (finishMemory-startMemory)/count );
    }

    private long getCurrentMemory(){
        return runtime.totalMemory() - runtime.freeMemory();
    }
}