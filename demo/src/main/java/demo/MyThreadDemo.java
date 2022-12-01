package demo;

/**
 * @author ：hongyan
 * @date ：Created in 2022/9/9 09:33
 * @description：10个线程打印1-10
 */
class myThread extends Thread {
    private int num;
    private static int flag = 1;
    private static final Object obj = new Object();  // final修饰保证局部变量和内部类变量的一致性

    public myThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (obj) {
            while (num != flag) {
                try {
                    obj.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + num);
            flag++;
            obj.notifyAll();
        }
    }
}
public class MyThreadDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            myThread t = new myThread(i);
            t.start();
        }
    }
}