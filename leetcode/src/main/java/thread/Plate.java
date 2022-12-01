package thread;

public class Plate {
    private int apple;
    private static volatile boolean state = false;

    public synchronized void putApple(int apple) {
        if (state) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.apple = apple;
        System.out.println("爸爸将第---" + apple + "---苹果放进盘子里了");
        state = true;
        notifyAll();
    }

    public synchronized void getApple() {
        if (!state) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("我吃掉了第---" + this.apple + "---个苹果");
        state = false;
        notifyAll();
    }

    public int getCount() {
        return apple;
    }
}
