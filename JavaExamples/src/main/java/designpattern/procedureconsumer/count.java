package designpattern.procedureconsumer;

class count {
    private static int num = 0;

    private count() {
    }

    public static int getNum() {
        synchronized (count.class) {
            num++;
            return num;
        }
    }
}