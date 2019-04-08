package oom;

public class FirstInit {
    public FirstInit() {
        SecondInit B = new SecondInit();
    }

    public static void main(String[] args) {
        System.out.println("Start");
        FirstInit first = new FirstInit();
        System.out.println("End");
    }
}
