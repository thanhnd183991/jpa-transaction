package thanh.be.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThread2 {
    private static PoolThread2 poolThread = null;
    private ExecutorService pool = null;

    private PoolThread2(){
        pool = Executors.newFixedThreadPool(3);
    }

    public static synchronized PoolThread2 getInstance(){
        if (poolThread == null){
            poolThread = new PoolThread2();
        }
        return poolThread;
    }

    public void submit(Runnable runnable){
        pool.execute(runnable);
    }
}
