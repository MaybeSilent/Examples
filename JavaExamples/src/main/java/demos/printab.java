package demos;
/**
 * wait notify简单交替打印相应的内容
 */
class printthread implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                notify();
                System.out.println(Thread.currentThread().getName());
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        printthread writer = new printthread();
        Thread A = new Thread(writer, "A");
        Thread B = new Thread(writer, "B");
        A.start();
        B.start();
    }
}