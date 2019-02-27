package designpattern.procedureconsumer;

interface Container {
    boolean isempty();

    boolean isfull();

    int getNum();

    void add(int number);

    int remove();
}

/**
 * 未作同步处理的简单容器,未进行同步处理
 */
class simpleContainer implements Container {

    private int[] list;
    private int readpos;
    private int writepos;
    private int count;
    private int capacity;

    public simpleContainer(int capacity) {
        this.capacity = capacity;
        list = new int[capacity];
        count = writepos = readpos = 0;
    }

    public boolean isempty() {
        return count == 0;
    }

    public boolean isfull() {
        return capacity == count;
    }

    public int getNum() {
        return count;
    }

    public void add(int number) {
        if (count < capacity) {
            if (writepos == capacity)
                writepos = 0;
            list[writepos++] = number;
            count++;
        }
    }

    public int remove() {
        if (count > 0) {
            count--;
            if (readpos == capacity)
                readpos = 0;
            return list[readpos++];
        }
        return -1;
    }
}
