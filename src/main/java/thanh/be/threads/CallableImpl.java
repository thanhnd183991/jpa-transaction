package thanh.be.threads;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable {
    private int i;
    public CallableImpl(int i){
        this.i = i;
    }

    @Override
    public Object call() throws Exception {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "-------" + i);
            return (Object) ("return " + i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
