package designpattern.procedureconsumer;


class mainprocess{
    public static void main(String[] args){
        Container container = new simpleContainer(5);
        Object lock = new Object();

        for(int i = 0 ; i < 5 ; i++){
            new Thread(new procedureconsumer(lock, container),"procedure" + i).start();
        }

        new Thread(new consumer(lock, container),"consumer").start();
    }
}