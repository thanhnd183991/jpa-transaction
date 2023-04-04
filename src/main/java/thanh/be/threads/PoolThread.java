package thanh.be.threads;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PoolThread {
    private static PoolThread poolThread = null;
    private ExecutorService pool = null;

    private PoolThread(){
        pool = Executors.newFixedThreadPool(3);
    }

    public static synchronized PoolThread getInstance(){
        if (poolThread == null) {
            poolThread = new PoolThread();
        }
        return poolThread;
    }

    public List<Future<Object>> submit(List<Callable> callables){
        List<Future<Object>> rs = new ArrayList<>();
        for(Callable callable: callables){
            rs.add(pool.submit(callable));
        }
        return rs;
    }

    public void shutdown(){
        this.pool.shutdown();
    }

    public void checkTerminated(int i){
        System.out.println("terminated in line " + i + ": " + this.pool.isTerminated());
        return;
    }
}
