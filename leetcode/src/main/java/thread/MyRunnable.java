package thread;

/**
 * @author ：hongyan
 * @date ：Created in 2022/7/26 21:41
 * @description：my_runnable
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String str) {
        this.command = str;
    }
    @Override
    public void run() {
        System.out.println("thread--" + Thread.currentThread().getName() + "start at " + System.currentTimeMillis());
        processCommand();
        System.out.println("thread--" + Thread.currentThread().getName() + "end at " + System.currentTimeMillis());
    }

    private void processCommand() {
        try{
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return command;
    }
}
