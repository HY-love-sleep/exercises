package demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/14 19:01
 * @description：原子引用
 */
@Getter
@AllArgsConstructor
@ToString
class User {
    private String userName;
    private int age;
}
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User hongyan = new User("hongyan", 25);
        User zhangchang = new User("zhangchang", 24);

        AtomicReference<User> atomicReference = new AtomicReference<>();

        atomicReference.set(hongyan);

        System.out.println(atomicReference.compareAndSet(hongyan, zhangchang) + "       current user is :" + atomicReference.get().toString());

    }
}
