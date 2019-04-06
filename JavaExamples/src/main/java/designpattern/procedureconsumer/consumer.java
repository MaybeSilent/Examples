package designpattern.procedureconsumer;

class consumer implements Runnable {
    private Object lock;
    private Container container;

    public consumer(Object lock, Container container) {
        this.lock = lock;
        this.container = container;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                while (container.isempty()) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int num = container.remove();
                lock.notify();

                System.out.println(Thread.currentThread().getName() + ": get num of " + num);
            }
        }
    }
}