package ProducerAndConsumer;

public class Box {
    private int milk;
    private boolean state = false;

    public synchronized void putMilk(int milk) {
        if (state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.milk = milk;
        System.out.println("送奶工将第" + milk + "瓶奶送入；");
        state = true;
        notifyAll();
    }

    public synchronized void getMilk() {
        if (!state) {
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("用户拿到第" + this.milk + "瓶奶；");
        state = false;
        notifyAll();
    }
}
