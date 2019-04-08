package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static  void main(String[] args) {
//        ArrayList<User> list = new ArrayList<>();
//        list.add(new User(10,"lili"));
//        list.add(new User(12,"lilei"));
//        list.add(new User(9,"wangmeimei"));
//        list.add(new User(20,"Missli"));
//
//        Collections.sort(list,(User u1, User u2) -> u2.getAge() - u1.getAge());
//
//        for (User user : list) {
//            System.out.println(user.getName() + " " + user.getAge() );
//        }

        int capacity = 10;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(10,
                (a , b) -> b - a);
        for(int i = 0; i < capacity; i++) {
            maxQueue.add((int)(Math.random()*100));
        }

        for(int i = 0; i < capacity; i++) {
            System.out.println(maxQueue.poll());
        }

    }
}
