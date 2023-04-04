package thanh.be.threads;

public class RunnableImpl implements Runnable{
    private int i;
    public RunnableImpl(int i){
        this.i = i;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "-------" + i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
