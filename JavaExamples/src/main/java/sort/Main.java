package sort;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static  void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(10,"lili"));
        list.add(new User(12,"lilei"));
        list.add(new User(9,"wangmeimei"));
        list.add(new User(20,"Missli"));

        Collections.sort(list,(User u1, User u2) -> u2.getAge() - u1.getAge());

        for (User user : list) {
            System.out.println(user.getName() + " " + user.getAge() );
        }
    }
}
