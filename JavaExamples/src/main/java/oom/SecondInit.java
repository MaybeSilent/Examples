package oom;

public class SecondInit {
    public SecondInit() {
//        int[] memory = new int[1024*1024*1024];
//        加入上述语句，会造成OutOfMemory
//        不加入上述语句，造成相应的StackOverflowError
        FirstInit A = new FirstInit();
    }
}
