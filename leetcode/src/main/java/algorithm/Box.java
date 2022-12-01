package algorithm;

public class Box {
    private int orange;
    private boolean state = false;

    public synchronized void putOrange(int i) {
        if (state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.orange = i;
        System.out.println("第" + i + "个桔子被放入盘子中;");
        state = true;
        notifyAll();
    }

    public synchronized void getOrange() {
        if (!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("第" + this.orange + "个桔子被取出;");
        state = false;
        notifyAll();
    }
}
