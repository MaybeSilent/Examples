package designpattern.procedureconsumer;

class procedureconsumer implements Runnable {
    private Object lock;
    private Container container;

    public procedureconsumer(Object lock, Container container) {
        this.lock = lock;
        this.container = container;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10 ; i++){
            //System.out.println("endsleeping");
            synchronized (lock) {
                while (container.isfull()) {
                    //System.out.println("isfull");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int num = count.getNum();
                container.add(num);
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + ": add num of " + num);
                
            }
        }
    }
}