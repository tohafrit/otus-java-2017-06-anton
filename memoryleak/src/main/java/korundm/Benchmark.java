package korundm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton.
 */
public class Benchmark implements BenchmarkMBean {

    private static final int TIME_WAIT = 50;
    private int size = 0;

    // по каждому garbage collection
    private long[] countGC, totalCount, timeGC, totalTime;
    private List<GarbageCollectorMXBean> gcBeans;
    private List<String> list = new ArrayList<>();

    @SuppressWarnings("InfiniteLoopStatement")
    void run() {
        init();

        System.out.println("Starting the loop");
        while (true) {
            int localSize = size;
            for (int i = 0; i < localSize; i++) {
                list.add("");
            }
            System.out.println("Created " + localSize + " objects.");

            for (int i = 0; i < localSize/2; i++) {
                list.remove(i);
            }
            System.out.println("Removed " + localSize/2 + " objects.");

            try {
                Thread.sleep(TIME_WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            printGC();
        }
    }

    private void init() {
        gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        countGC = new long[gcBeans.size()];
        totalCount = new long[gcBeans.size()];
        timeGC = new long[gcBeans.size()];
        totalTime = new long[gcBeans.size()];
    }

    private void printGC() {
        for (int i = 0; i < gcBeans.size(); i++) {
            GarbageCollectorMXBean gcBean = gcBeans.get(i);

            long gcCount = gcBean.getCollectionCount() - countGC[i];
            long gcTimeMillis = gcBean.getCollectionTime() - timeGC[i];
            totalTime[i] += gcTimeMillis;
            totalCount[i] += gcCount;

            countGC[i] = gcBean.getCollectionCount();
            timeGC[i] = gcBean.getCollectionTime();

            System.out.println(gcBean.getName() + ": gcCount - " + gcCount + "; gcTimeMillis - " + gcTimeMillis + "; totalCount - " + totalCount[i] + "; totalTime - " + totalTime[i]);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}