package stackoverflow;

import java.util.concurrent.CopyOnWriteArrayList;

class SharedArray {
    public CopyOnWriteArrayList<Integer> arr = new CopyOnWriteArrayList<>();

    public void increment(int index) {
        arr.set(index, arr.get(index)+1);  // Not thread-safe (Race Condition)
    }
}

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        // SharedArray sharedArray = new SharedArray();
        // sharedArray.arr.add(0);

        // Runnable task = () -> {
        //     for (int i = 0; i < 1000; i++) {
        //         sharedArray.increment(0);  // Multiple threads modifying arr[0]
        //     }
        //     // sharedArray.printArray();
        // };

        // Thread t1 = new Thread(task);
        // Thread t2 = new Thread(task);

        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();

        // System.out.println("Final Array: " + sharedArray.arr);
    }
}

