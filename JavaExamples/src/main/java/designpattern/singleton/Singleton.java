package designpattern.singleton;
/**
 * 单例模式的三种写法
 */


/**
 * output：
 * 第一种，最简单的写法
 * 缺点：从类初始化开始就存在，并未实现延迟加载机制
 */
class firstSingle {
    //static final 
    private static final firstSingle INSTANCE = new firstSingle();

    private firstSingle() {
        System.out.println("first singleton inited");
    }

    public static firstSingle getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("enter main");
        firstSingle first = firstSingle.getInstance();
        firstSingle second = firstSingle.getInstance();
        System.out.println(first == second);
    }
}

/**
 * 双重判断实现单例模式 ， 能够实现相应的延迟加载机制 ，且效率也较高
 */
class secondSingle {
    private static volatile secondSingle INSTANCE;

    private secondSingle() {
        System.out.println("second inited");
    }

    public static secondSingle getInstance() {
        if (INSTANCE == null) {
            synchronized (secondSingle.class) {
                if (INSTANCE == null) {
                    INSTANCE = new secondSingle();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("example inited"); //用于验证延迟加载
        secondSingle first = secondSingle.getInstance();
        secondSingle second = secondSingle.getInstance();
        System.out.println(first == second);
    }

}

/**
 * 通过静态内部类来实现相应的单例模式
 */

class thirdSingle {
    private static class innerSingle {
        private final static thirdSingle INSTANCE = new thirdSingle();
    }

    private thirdSingle() {
        System.out.println("first single inited");
    }

    public static thirdSingle getInstance() {
        return innerSingle.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("example inited"); //用于验证延迟加载
        thirdSingle first = thirdSingle.getInstance();
        thirdSingle second = thirdSingle.getInstance();
        System.out.println(first == second);
    }

}

/**
 * static 变量的声明周期
 * 静态变量 ==> 静态代码块初始化
 */
public class Singleton {
    public static void main(String[] args) {
        System.out.println("enter out main");
        firstSingle first = firstSingle.getInstance();
        firstSingle second = firstSingle.getInstance();
        System.out.println(first == second);
    }
}

