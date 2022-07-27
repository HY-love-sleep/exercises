package ThreadTest;


/**
 * @author ：hongyan
 * @date ：Created in 2022/7/27 10:48
 * @description：box
 */
public class Box {
    private int milk;
    private boolean state = false;

    public synchronized void putMilk(int i) {
        if (state) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        this.milk = i;
        System.out.println("送奶工" + Thread.currentThread().getName() + "将第" + String.valueOf(i) + "瓶奶放入了奶箱");
        state = true;
        notifyAll();
    }

    public synchronized void getMilk() {
        if (!state) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("洪岩喝到了第" + milk + "瓶奶");
        state = false;
        notifyAll();
    }
}
